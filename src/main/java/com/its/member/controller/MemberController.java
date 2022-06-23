package com.its.member.controller;

import com.its.member.dto.MemberDTO;
import com.its.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor // final이 붙거나 @NotNull 이 붙은 필드의 생성자를 자동 생성해주는 롬복 어노테이션
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/save-form") //회원가입 화면 요청
    public String saveForm(){
        return "/memberPages/save";
    }
    @PostMapping("/save") //회원가입 처리
    public String save(@ModelAttribute MemberDTO memberDTO){
        memberService.save(memberDTO);
        return "memberPages/login";
    }
    @GetMapping("/login-form") //로그인 화면
    public String loginForm(){
        return "memberPages/login";
    }

    @PostMapping("/login") //로그인 처리
    public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session){
        MemberDTO loginResult = memberService.login(memberDTO);
        session.setAttribute("loginEmail",loginResult.getMemberEmail());
        session.setAttribute("id",loginResult.getId());
        if (loginResult != null){
            return "memberPages/mypage";
        }else {
            return "memberPages/login";
        }
    }

    @GetMapping("/") //회원목록
    public String findAll(Model model){
        List<MemberDTO> memberDTOList = memberService.findAll();
        model.addAttribute("memberList",memberDTOList);
        return "memberPages/list";
    }
    // member/3
    // member?id=3
    @GetMapping("/{id}") // 파리미터 값을 담아줌
    public String findById(@PathVariable Long id, Model model){
        MemberDTO memberDTO = memberService.findById(id);
        model.addAttribute("member",memberDTO);
        return "memberPages/detail";

    }

    @PostMapping("/ajax/{id}") // ajax 상세조회
    public @ResponseBody MemberDTO findByIdAjax(@PathVariable Long id){
        MemberDTO memberDTO = memberService.findById(id);
        return memberDTO;
    }

    @GetMapping("/delete/{id}") //get 요청 삭제 /member/delete/3
    public String delete(@PathVariable Long id){
        memberService.delete(id);
        return "redirect:/member/";
        // return "memberPages/list"; 이런실수는 하면 안된다. x
    }

    /**
     * /member/3: 조회(get 요청) R ,저장(post 요청) C,수정(put 요청) U,삭제(delete 요청) D
     */

    @DeleteMapping("/{id}") // delete 요청 삭제
    public ResponseEntity deleteAjax(@PathVariable Long id){
        memberService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK); // ajax 호출한 부분에 리턴으로 200 응답을 줌.
    }

    @GetMapping("/update") //수정화면 요청
    public String updateForm(HttpSession session,Model model){
       Long id = (Long) session.getAttribute("id"); //강제형 변환
       MemberDTO memberDTO = memberService.findById(id);
       model.addAttribute("updateMember",memberDTO);
       return "memberPages/update";

    }

    @PostMapping("update") //수정처리
    public String update(@ModelAttribute MemberDTO memberDTO){
        memberService.update(memberDTO);
        return "redirect:/member" +memberDTO.getId();
    }

    @PutMapping("/{id}") //수정처리(put 요청) json 형식에서 불러올때는 @requestBody put처리는 ajax로 이용한다
    public ResponseEntity updateByAjax(@RequestBody MemberDTO memberDTO){
        memberService.update(memberDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

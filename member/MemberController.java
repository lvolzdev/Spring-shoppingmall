package com.example.demo.member;

import com.example.demo.utils.ApiUtils;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.example.demo.utils.ApiUtils.error;
import static com.example.demo.utils.ApiUtils.success;

@Slf4j
@AllArgsConstructor
@RestController
public class MemberController {

    MemberService memberService;

    @PostMapping("/join")
    public ApiUtils.ApiResult join(@Valid @RequestBody MemberDto memberDto) {
//        if (errors.hasErrors()) {
//            Map<String, String> errorMessages
//                    = new HashMap<>();
//
//            for (FieldError error : errors.getFieldErrors()) {
//                String errorField = error.getField(); // 예외 field
//                String errorMessage = error.getDefaultMessage(); // 예외 message
//                errorMessages.put(errorField, errorMessage);
//            }
//
//            return error(errorMessages.toString(), HttpStatus.BAD_REQUEST);
//        }
        log.info(memberDto.toString());

        if(isDuplicateId(memberDto))
            return error("아이디 중복", HttpStatus.CONFLICT);

        Member requestMember = memberDto.convertToEntity();
        String userId = memberService.join(requestMember);
        return success(userId);
    }

    private boolean isDuplicateId(MemberDto member) {
        return memberService.checkDuplicateId(member.getUserId());
    }
}

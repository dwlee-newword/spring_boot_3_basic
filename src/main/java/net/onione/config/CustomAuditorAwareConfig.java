package net.onione.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
@Slf4j
public class CustomAuditorAwareConfig implements AuditorAware<String> {

//    private final AuthenticationFacade authenticationFacade;

    @Override
    public Optional<String> getCurrentAuditor() {
        try {
//            Authentication authentication = authenticationFacade.getAuthentication();
//
//            if(authentication instanceof UserLoginAuthSession){
//                UserLoginAuthSession userLoginAuthSession = (UserLoginAuthSession) authentication;
//                return Optional.of(String.format("[%s][%s][%s]", userLoginAuthSession.getUserType(), userLoginAuthSession.getUserId(), userLoginAuthSession.getUsername()));  // 권한정보 + entity id
//            }

            //TODO:MEMO BizUser, SystemUser도 위처럼 처리해야함.

            return Optional.of("ANONYMOUS"); // 인증이 안된 사용자.
        } catch (ClassCastException e) {
            return Optional.of("ANONYMOUS"); // 인증이 안된 사용자.
        }
    }
}
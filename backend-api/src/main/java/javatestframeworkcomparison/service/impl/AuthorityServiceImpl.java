package javatestframeworkcomparison.service.impl;

import javatestframeworkcomparison.model.user.Authority;
import javatestframeworkcomparison.model.user.AuthorityType;
import javatestframeworkcomparison.repository.AuthorityRepository;
import javatestframeworkcomparison.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "authorityService")
public class AuthorityServiceImpl implements AuthorityService {

    private final AuthorityRepository authorityRepository;

    @Autowired
    public AuthorityServiceImpl(AuthorityRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }

    @Override
    public Authority findAuthorityByAuthorityType(AuthorityType authorityType) {
        return authorityRepository.findByAuthorityType(authorityType)
                .orElseGet(() -> authorityRepository.save(new Authority(authorityType)));
    }
}

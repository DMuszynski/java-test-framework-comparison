package pl.dmuszynski.javatestframeworkcomparison.service.impl;

import pl.dmuszynski.javatestframeworkcomparison.model.Authority;
import pl.dmuszynski.javatestframeworkcomparison.model.AuthorityType;
import pl.dmuszynski.javatestframeworkcomparison.repository.AuthorityRepository;
import pl.dmuszynski.javatestframeworkcomparison.service.AuthorityService;
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

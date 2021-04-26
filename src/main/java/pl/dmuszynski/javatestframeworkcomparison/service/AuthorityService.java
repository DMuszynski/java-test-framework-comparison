package pl.dmuszynski.javatestframeworkcomparison.service;

import pl.dmuszynski.javatestframeworkcomparison.model.user.Authority;
import pl.dmuszynski.javatestframeworkcomparison.model.user.AuthorityType;

public interface AuthorityService {
    Authority findAuthorityByAuthorityType(AuthorityType authorityType);
}

package pl.dmuszynski.javatestframeworkcomparison.service;

import pl.dmuszynski.javatestframeworkcomparison.model.Authority;
import pl.dmuszynski.javatestframeworkcomparison.model.AuthorityType;

public interface AuthorityService {
    Authority findAuthorityByAuthorityType(AuthorityType authorityType);
}

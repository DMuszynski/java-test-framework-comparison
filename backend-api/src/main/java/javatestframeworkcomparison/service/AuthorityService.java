package javatestframeworkcomparison.service;

import javatestframeworkcomparison.model.user.Authority;
import javatestframeworkcomparison.model.user.AuthorityType;

public interface AuthorityService {
    Authority findAuthorityByAuthorityType(AuthorityType authorityType);
}

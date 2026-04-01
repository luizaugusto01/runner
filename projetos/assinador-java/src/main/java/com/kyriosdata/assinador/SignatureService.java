package com.kyriosdata.assinador;

import com.kyriosdata.assinador.domain.SignatureRequest;
import com.kyriosdata.assinador.domain.SignatureResponse;

public interface SignatureService {
    SignatureResponse sign(SignatureRequest request);
    SignatureResponse validate(SignatureRequest request);
}

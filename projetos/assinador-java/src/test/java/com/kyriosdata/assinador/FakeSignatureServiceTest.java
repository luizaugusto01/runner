package com.kyriosdata.assinador;

import com.kyriosdata.assinador.domain.SignatureRequest;
import com.kyriosdata.assinador.domain.SignatureResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FakeSignatureServiceTest {

    private final SignatureService service = new FakeSignatureService();

    @Test
    void shouldReturnSimulatedSignatureForValidSignRequest() {
        SignatureRequest request = new SignatureRequest();
        request.setContent("sample content");
        
        SignatureResponse response = service.sign(request);
        
        assertNotNull(response);
        assertTrue(response.isValid());
        assertEquals("MOCKED_SIGNATURE_BASE64_==", response.getSignature());
        assertEquals("Assinatura criada com sucesso", response.getMessage());
    }

    @Test
    void shouldReturnErrorForInvalidSignRequest() {
        SignatureRequest request = new SignatureRequest();
        request.setContent(null); // Invalid
        
        SignatureResponse response = service.sign(request);
        
        assertNotNull(response);
        assertFalse(response.isValid());
        assertNull(response.getSignature());
        assertEquals("Parâmetro 'content' inválido ou ausente", response.getMessage());
    }

    @Test
    void shouldValidateSimulatedSignatureCorrectly() {
        SignatureRequest request = new SignatureRequest();
        request.setContent("sample content");
        request.setSignature("MOCKED_SIGNATURE_BASE64_==");
        
        SignatureResponse response = service.validate(request);
        
        assertNotNull(response);
        assertTrue(response.isValid());
        assertEquals("Assinatura é válida", response.getMessage());
    }

    @Test
    void shouldReturnErrorForInvalidSimulatedSignature() {
        SignatureRequest request = new SignatureRequest();
        request.setContent("sample content");
        request.setSignature("BAD_SIGNATURE_==");
        
        SignatureResponse response = service.validate(request);
        
        assertNotNull(response);
        assertFalse(response.isValid());
        assertEquals("Assinatura é inválida", response.getMessage());
    }
}

package liveDio.SomaVotos.controller.games;

import liveDio.SomaVotos.controller.ApiErrorDTO;
import liveDio.SomaVotos.service.exception.BusinessException;
import liveDio.SomaVotos.service.exception.NoContentException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api")
public abstract class BaseRestControler {

    @ExceptionHandler(NoContentException.class)
    public ResponseEntity<Void> handlerNoContentException(NoContentException exception){
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiErrorDTO> handlerBusinessException(BusinessException exception){
        ApiErrorDTO error = new ApiErrorDTO(exception.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ApiErrorDTO> handlerUnexpectedException(Throwable exception){
        ApiErrorDTO error = new ApiErrorDTO("Ops, ocorreu um erro inesperado.");
        exception.printStackTrace();
        return ResponseEntity.internalServerError().body(error);
    }
}

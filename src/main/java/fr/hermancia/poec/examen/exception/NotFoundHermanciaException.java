package fr.hermancia.poec.examen.exception;

import lombok.Getter;
@Getter
public class NotFoundHermanciaException extends RuntimeException{




        private final String type;

        private final String field;

        private final Object value;

        public NotFoundHermanciaException(String type, String field, Object value) {
            super("L'élément que vous recherchez n'existe pas");
            this.type = type;
            this.field = field;
            this.value = value;
        }
    }


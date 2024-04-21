package com.sena.biblioteca.DTO;

import java.sql.Date;

public interface IPrestamoDto extends IGenericDto{
    Date getFechaPrestamo();
    Date getFechaDevolucionEstimada();
    IEjemplarDto getEjemplar();
    IUsuarioDto getUsuario();
}

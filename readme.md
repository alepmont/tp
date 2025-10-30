/* ==================== EXPLICACIÓN PARA JUNIOR =====================

ARQUITECTURA EN CAPAS:

CONTROLADOR (Presentación):

Recibe solicitudes HTTP (GET, POST, etc.)
Valida entrada
Llama al Servicio
Devuelve respuesta HTTP
SERVICIO (Lógica de Negocio):

Contiene las reglas del negocio.
Coordina entre Controller y DAO
Transforma Entidades ↔ DTOs
DAO (Acceso a):

Se comunica con la base de datos
CRUD
Consultas personalizadas
MODELO (Entidades):

Representa tablas de BD
Contiene toda la información
DIFERENCIAS CLAVE:

• ENTIDAD (Producto): Mapeo directo de la tabla en BD. Tiene TODOS los campos. • DTO (ProductoDTO): Solo datos que se exponen en la API. Puede tener campos calculados. • DAO: Interfaz que hereda de JpaRepository para operaciones de BD.

¿POR QUÉ USAR DTOs?

Seguridad: No exponer campos sensibles (ej: contraseñas)
Rendimiento: Enviar solo los datos necesarios
Desacoplamiento: La API no depende de la estructura de BD
Flexibilidad: Agregar campos calculados (ej: "disponible")
RESULTADOS DE LOS PUNTOS FINALES:

GET /api/productos → Lista todos GET /api/productos/{id} → Obtiene uno POST /api/productos → Crea nuevo PATCH /api/productos/{id}/stock → Actualiza stock GET /api/productos/disponibles → Solo con stock

====================================================== /

de
No se proporciona descripción, sitio web ni temas.
Recursos
 Léeme
 Actividad
Estrellas
 0 estrellas
Vigilantes
 0 espectadores
Tenedores
 0 tenedores
Lanzamientos
No se han publicado comunicados.
Crear una nueva versión
los
No hay paquetes publicados.
Publica tu primer paquete.
Pie de página

# Actividad Springboot trainning sofka
En este repositorio se encuentra el codigo desarrollado para la
actividad propuesta en la clase de la
liga de entrenamiento de sofka, para concretar el tema de
springboot.


## Desarrollo de la actividad

Al ejercicio desarrolado pro el profesor (https://github.com/edgarsofka/demoCrudTEST.git)
se:
- Agrego un endPoint de actualizacion de usuario

- Incorporo una nueva entidad/modelo(UsuarioRol) que tiene 
los campos (idUsuario,idRol,Rol("vendedor","cajero","consultor",etc..)). 

- Implemente algunas pruebas unitarias a esa nueva entidad/modelo.

### Relacion Usuario - UsuarioRol

Un usuario puede en un momento tener uno o mas roles asociados, es decir tiene una relacion de
un (usuario) a muchos (roles). adicionalmente, dos usuarios podrian tener el mismo rol, es decir un rol 
puede repetirse en mucho usuarios. Por lo tanto se puede concluir que entre ellos (Usuario - UsuarioRol) existe
una relación de muchos a muchos (@ManyToMany Relation.), dado que esta es la definición de
esa relación. 







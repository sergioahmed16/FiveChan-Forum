# 🍀 FiveChan Forum 🍀

## Descripción

Este proyecto es una implementación de un foro llamado Fivechan. La clase `ForumService` se encarga de la lógica de negocio para la gestión de temas, comentarios y usuarios en el foro.
Para aplicar las convenciones de codificación del lenguaje de programación (Java) y mejorar la legibilidad del código en la clase ForumService, seguiremos las mejores prácticas de Java. Estas incluyen:

Nombres Descriptivos: Usar nombres claros y significativos para métodos y variables.
Comentarios: Añadir comentarios donde sea necesario para explicar la lógica del código.
Separación de Responsabilidades: Asegurarnos de que cada método haga una sola cosa.
Convenciones de Estilo: Seguir las convenciones de estilo de Java, como el uso de camelCase para los nombres de métodos y variables, y PascalCase para los nombres de clases.

## Mejoras de Código Limpio Aplicadas

Para mejorar la legibilidad y mantenibilidad del código en la clase `ForumService`, hemos aplicado las siguientes prácticas de código limpio:

### 1. Nombres Descriptivos y Comentarios

- **Nombres Descriptivos**: Los métodos ahora tienen nombres claros y significativos que explican su propósito.
- **Comentarios**: Se han añadido comentarios donde es necesario para explicar la lógica del código.

#### Ejemplo de Código Mejorado

```java
@Override
public void editTopic(Long id, Topic topic) {
    Topic existingTopic = findTopicById(id);
    updateTopic(existingTopic, topic);
    saveTopic(existingTopic);
}

/**
 * Encuentra un tema por su ID.
 * @param id El ID del tema.
 * @return El tema encontrado.
 */
private Topic findTopicById(Long id) {
    return topicRepository.findById(id);
}
```
### 2. Refactorización de la Estructura del Código

-Extraemos la lógica en métodos más pequeños para que cada método haga una sola cosa, asegurándonos de que cada método tenga una responsabilidad única.
#### Ejemplo de Código Mejorado

```java
@Override
public void commentOnTopic(Long topicId, Comment comment) {
    Topic topic = findTopicById(topicId);
    topic.addComment(comment);
    saveTopic(topic);
}

/**
 * Encuentra un comentario por su ID.
 * @param id El ID del comentario.
 * @return El comentario encontrado.
 */
private Comment findCommentById(Long id) {
    return topicRepository.findCommentById(id);
}

/**
 * Actualiza un comentario existente con nuevos datos.
 * @param existingComment El comentario existente.
 * @param newCommentData Los nuevos datos del comentario.
 */
private void updateComment(Comment existingComment, Comment newCommentData) {
    existingComment.setContent(newCommentData.getContent());
}

/**
 * Guarda un comentario en el repositorio.
 * @param comment El comentario a guardar.
 */
private void saveComment(Comment comment) {
    topicRepository.save(comment);
}

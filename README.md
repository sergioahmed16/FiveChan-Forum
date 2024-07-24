# 🍀 FiveChan Forum 🍀

## Overview
The FiveChan Forum Application is a modern, Spring Boot-based forum system designed to facilitate discussions through topics and comments. It allows users to create, edit, and delete topics and comments. Additionally, it includes features for censoring topics, warning users, suspending, and banning users based on the forum's moderation policies.

## Principios SOLID Aplicados y Archivos Creados

### 1. Principio de Responsabilidad Única (SRP)

Descripción: Cada clase debe tener una única responsabilidad o razón para cambiar.

Archivo Creado:
- `src/main/java/com/fchanblog/fivechan/application/service/WarningService.java`

Propósito:
La clase `WarningService` se encarga exclusivamente de la lógica de gestión de advertencias, separando esta responsabilidad de la clase `User`.


### 2. Principio de Abierto/Cerrado (OCP)

Descripción: Las clases deben estar abiertas para extensión, pero cerradas para modificación.

### Cambio Realizado: `UserWithRoles`

Se creó una nueva clase `UserWithRoles` que extiende `User` para añadir la capacidad de gestionar roles, sin modificar la clase `User`.

### Archivos Creados

#### `src/main/java/com/fchanblog/fivechan/domain/model/UserWithRoles.java`

Descripción: Esta clase extiende la funcionalidad de la clase `User` para incluir la gestión de roles, permitiendo así agregar roles adicionales a los usuarios sin modificar la implementación existente de `User`.

### 3. Principio de Sustitución de Liskov (LSP)

Descripción: Las clases derivadas deben ser sustituibles por sus clases base.

### Cambio Realizado: `UserService`

Se aseguró que `UserWithRoles` puede ser utilizada en lugar de `User` en el servicio de usuarios (`UserService`), garantizando que las instancias de la clase derivada puedan reemplazar a las de la clase base sin alterar el comportamiento esperado del programa.

### Archivos Creados

#### 1. `src/main/java/com/fchanblog/fivechan/application/service/UserService.java`

Descripción. Esta clase proporciona métodos para crear usuarios, tanto básicos como con roles, utilizando la clase base `User` y la clase derivada `UserWithRoles`.

## Features
- **Topic Management**: Users can create, edit, and delete topics.
- **Comment System**: Users can comment on topics, edit their comments, and delete them.
- **Moderation Tools**: Moderators can censor topics, warn users, suspend or ban users from the forum.

## Technologies
- **Java**: The primary programming language used.
- **Spring Boot**: Framework for creating stand-alone, production-grade Spring-based Applications.
- **Maven**: Dependency management and build tool.
- **PostgreSQL**: Database for storing all forum data.

## Getting Started

### Prerequisites
- Java 21
- Maven
- Docker (for running PostgreSQL in a container)

### Setup
1. **Clone the repository**
   ```bash
   git clone https://github.com/natzgun/fivechan.git
   cd fivechan

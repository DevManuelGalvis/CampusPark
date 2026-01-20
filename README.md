# 🎢 CampusPark – Sistema de Gestión de Parque de Atracciones (POO Java)

## 📌 Descripción del proyecto

**CampusPark** es un sistema desarrollado en **Java** que modela el funcionamiento básico de un parque de atracciones utilizando **Programación Orientada a Objetos (POO)**.  
El sistema permite gestionar visitantes, tickets, atracciones de distintos tipos, colas, operación por turnos, mantenimiento y recaudo total del parque.

Este proyecto fue desarrollado como parte del **Taller POO Java: Parque de Atracciones “CampusPark”**.

---

## 🎯 Objetivos del sistema

- Registrar visitantes con validaciones
- Gestionar atracciones con diferentes restricciones
- Vender y procesar tickets
- Encolar visitantes en atracciones
- Operar atracciones por turnos
- Registrar mantenimiento y controlar estados
- Calcular recaudo total del parque


---

## 🧩 Componentes principales

### 👤 Visitantes

- Atributos:
  - `id`
  - `nombre`
  - `edad`
  - `alturaCm`
  - `sabeNadar`
- Validaciones:
  - Edad y altura no negativas
- Encapsulamiento con atributos `private`

---

### 🎢 Atracciones

Clase abstracta `Atraccion` con:

- `id`
- `nombre`
- `capacidadPorTurno`
- `precioBase`
- `estado` (`OPERATIVA`, `EN_MANTENIMIENTO`, `FUERA_DE_SERVICIO`)
- `riesgo` (`BAJO`, `MEDIO`, `ALTO`)
- Cola de tickets por turno

#### Tipos de atracciones

- **Atracción Mecánica**
  - Restricción: altura mínima
- **Atracción Infantil**
  - Restricción: edad máxima
- **Atracción Acuática**
  - Restricción: saber nadar

Cada tipo redefine:
- `puedeIngresar(Visitante v)`
- `calcularCosto(Ticket t)` (polimorfismo)

---

### 🎟️ Tickets

- Tipos:
  - `DIARIO`
  - `VIP`
- Reglas:
  - Cada atracción calcula el costo final
  - Tickets VIP aplican descuento base
  - Algunas atracciones pueden aplicar recargos o descuentos adicionales

---

### 🔧 Mantenimiento

- Registro de mantenimiento incluye:
  - Fecha
  - Empleado responsable
  - Notas
- Cambia automáticamente el estado de la atracción a `EN_MANTENIMIENTO`
- Implementado mediante la interfaz `Inspeccionable`

---

### 🏗️ Parque

La clase `Parque` permite:

- Gestionar una lista de atracciones
- Operar atracciones por turnos
- Calcular y acumular el recaudo total
- Mostrar colas de visitantes

---

## ⚙️ Requerimientos POO aplicados

- ✔ Clases abstractas
- ✔ Herencia
- ✔ Interfaces
- ✔ Polimorfismo
- ✔ Encapsulamiento
- ✔ Enums
- ✔ Buenas prácticas de diseño

---

## ▶️ Ejecución del programa

1. Descargar o clonar el proyecto
2. Abrir en un IDE compatible con Java (IntelliJ, Eclipse, NetBeans)
3. Ejecutar la clase principal:

```java
main.Main

```
---
## 👨‍🎓 Autor

- DevManuelGalvis





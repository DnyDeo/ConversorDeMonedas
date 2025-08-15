# 💱 Conversor de Monedas - Java

Este es un programa en **Java** que permite convertir valores entre distintas monedas utilizando la API de [ExchangeRate API](https://www.exchangerate-api.com/).

El usuario puede:
- Ver un listado de monedas más usadas.
- Consultar todas las monedas disponibles desde la API.
- Realizar conversiones en tiempo real.
- Validar que los códigos y valores ingresados sean correctos.

---

## 🚀 Características

- ✅ Carga automática de monedas disponibles desde la API (`/codes`).
- ✅ Validación para aceptar únicamente monedas soportadas.
- ✅ Validación para que el monto a convertir sea numérico.
- ✅ Conversión de cualquier moneda a otra.
- ✅ Menú interactivo que permite realizar múltiples conversiones.

---

## 📦 Requisitos

Antes de ejecutar el proyecto, asegúrate de tener instalado:

- **Java 17** o superior.
- **Maven** (para gestionar dependencias).
- Conexión a Internet (para consultar la API).
  
---

## 🔧 Instalación y Ejecución

1. **Clonar el repositorio**
   ```bash
   git clone https://github.com/DnyDeo/conversordemonedas.git
   cd conversor-monedas

📌 Uso del Programa

Al iniciar, se mostrará una lista de monedas más usadas.

El usuario debe ingresar:
Código de moneda origen (ej: USD).
Código de moneda destino (ej: COP).
Ingresar el monto a convertir (solo valores numéricos).
El programa mostrará el valor convertido y permitirá seguir o salir.

   

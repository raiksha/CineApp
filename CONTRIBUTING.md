# Guía de Contribución

¡Gracias por contribuir a este proyecto! Por favor lee este documento antes de empezar a trabajar.

---

## Tabla de contenidos

- [Flujo de trabajo con Git](#flujo-de-trabajo-con-git)
- [Convención de commits](#convención-de-commits)
- [Convención de ramas](#convención-de-ramas)
- [Pull Requests](#pull-requests)
- [Estilo de código](#estilo-de-código)
- [Operaciones comunes con Git](#operaciones-comunes-con-git)
- [Trabajar con forks](#trabajar-con-forks)

---

## Flujo de trabajo con Git

1. Clona el repositorio y asegúrate de estar actualizado:
   ```bash
   git clone https://github.com/PabloDesk/CineApp
   git checkout main
   git pull origin main
   ```

2. Crea una rama nueva para tu tarea (ver [Convención de ramas](#convención-de-ramas)):
   ```bash
   git checkout -b feature/NombreApellido
   ```

3. Trabaja en tu rama, haciendo commits pequeños y frecuentes.

4. Antes de abrir un PR, sincroniza con `main`:
   ```bash
   git checkout feature/NombreApellido   # ← aquí estás
   git fetch origin
   git rebase origin/main
   ```

5. Abre un Pull Request hacia `main` y solicita revisión a al dueño del repositorio.

> ⚠️ **Nunca hagas push directo a `main`.** Todo cambio debe pasar por PR.

---

## Convención de commits

Usamos [Conventional Commits](https://www.conventionalcommits.org/es/). El formato es:

```
<tipo>(<ámbito>): <descripción breve en imperativo>
```

### Tipos permitidos

| Tipo       | Cuándo usarlo                                         |
|------------|-------------------------------------------------------|
| `feat`     | Nueva funcionalidad                                   |
| `fix`      | Corrección de bug                                     |
| `docs`     | Cambios solo en documentación                         |
| `style`    | Formato, espacios, comas (sin cambio de lógica)       |
| `refactor` | Reestructuración de código sin cambiar comportamiento |
| `chore`    | Tareas de mantenimiento, dependencias, config         |

### Ejemplos

```
feat(RefugioAnimales.java): agregar función mostrarReporte()
fix(RefugioAnimales.java): corregir error de scanner en main()
docs(CONTRIBUTING.md): actualizar CONTRIBUTING con detalles de Commits
```

---

## Convención de ramas

```
feature/<NombreApellido>
```

### Ejemplos

```
feature/DiegoCastillo
feature/JulioOyarzun
feature/SaryViafara
```

---

## Pull Requests

Antes de abrir un PR asegúrate de:

- [ ] Tu rama está actualizada con `main`
- [ ] El código compila/corre sin errores
- [ ] Seguiste las convenciones de commits y ramas
- [ ] El PR tiene un título descriptivo siguiendo la convención de commits
- [ ] Agregaste una descripción breve de qué cambia y por qué

Un PR debe será revisado y aprobado por el dueño del repositorio antes de hacer merge.

* Para crear una PR, luego de hacer push a tu rama, debes ingresar en tu navegador al [link del repositorio](https://github.com/MiskTake/Refugio-Animales).
* Te aparecerá el botón verde para crear la PR.

### Plantilla de descripción de la PR

En la descripción de la Pull Request deberás copiar y pegar este texto, agregar la descripción breve y marcar con una x lo que aplique.

```markdown
## Descripción
Breve explicación del cambio: qué problema resuelve y cómo.

## Tipo de cambio
- [ ] Fix (corrección de bug)
- [ ] Feature (nueva funcionalidad)
- [ ] Docs (documentación)
- [ ] Refactor / Perf / Chore

## Checklist
- [ ] Probado localmente
- [ ] Sin romper compatibilidad
- [ ] Agregué/actualicé documentación
- [ ] Aprobé linters/tests (si aplica)
```

* Las opciones que no marques, debes dejar el espacio entre los corchetes -> [ ].
* Las opciones que sí marques, debes **reemplazar** el espacio con una X -> [x].
> No deben quedar espacios entre los corchetes y la x.

---

## Estilo de código

- Escribe comentarios si es necesario explicar lógica compleja.
- Está bien agregar líneas vacías para separar bloques de código y que haya mejor legibilidad.
- Evita agregar líneas vacías en exceso o que no cumplan ninguna función.

---

## Operaciones comunes con Git

### Traer los últimos cambios de `main` a tu rama

Mientras trabajas, `main` puede avanzar. Para mantener tu rama actualizada:

```bash
git checkout feature/NombreApellido   # ← aquí estás
git fetch origin
git rebase origin/main
```

Si hay conflictos, Git te indicará qué archivos resolver. Una vez resueltos:

```bash
git add <archivos-resueltos>
git rebase --continue
```

> 💡 Preferir `rebase` sobre `merge` para mantener el historial limpio y lineal.

---

### Deshacer el último commit (sin perder los cambios)

Si hiciste un commit antes de tiempo:

```bash
git reset --soft HEAD~1
```

Tus cambios quedan en staging, listos para volver a commitear.

---

### Guardar cambios temporalmente sin commitear

Si necesitas cambiar de rama pero no quieres perder tu trabajo en progreso:

```bash
git stash
# cambia de rama, haz lo que necesites...
git stash pop   # recupera tus cambios
```

---

### Ver el estado de tu rama vs. `main`

```bash
git log origin/main..HEAD --oneline   # commits que tienes tú y main no
git diff origin/main                  # diferencia en el código
```

---

## Trabajar con forks

### Configuración inicial (solo una vez)

Agrega el repositorio original como remote `upstream`:

```bash
git remote add upstream https://github.com/PabloDesk/CineApp.git
git fetch upstream
git checkout -b dev upstream/dev
```

Esto crea tu rama local `dev` conectada a la rama `dev` del repo original.

### Traer cambios del repo original a tu fork

Cuando el repo original tenga cambios que necesitas incorporar:

```bash
git fetch upstream
git merge upstream/dev
```

Ejecuta esto estando en tu rama `dev` local. Trae los cambios del `dev` original y los fusiona con el tuyo.

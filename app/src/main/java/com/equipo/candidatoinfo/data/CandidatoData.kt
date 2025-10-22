package com.equipo.candidatoinfo.data

import com.equipo.candidatoinfo.model.*

object CandidatoData {

    fun getCandidatosEjemplo(): List<Candidato> {
        return listOf(
            // 1. Rafael López Aliaga - Renovación Popular
            Candidato(
                id = "candidato_1",
                nombre = "Rafael",
                apellido = "López Aliaga",
                edad = 60,
                partidoPolitico = "Renovación Popular",
                cargo = Cargo.PRESIDENCIA,
                region = "Lima",
                biografia = "Empresario peruano y actual alcalde de Lima. Candidato presidencial en 2021 y probable candidato para 2026. Conocido por su postura conservadora y católica, y por sus proyectos de infraestructura en Lima.",
                denuncias = listOf(
                    Denuncia(
                        titulo = "Conflictos de interés",
                        descripcion = "Cuestionamientos por presuntos conflictos de interés entre su gestión municipal y sus empresas.",
                        fecha = "2024",
                        tipo = TipoDenuncia.ADMINISTRATIVA,
                        estado = EstadoDenuncia.EN_PROCESO
                    )
                ),
                proyectos = listOf(
                    Proyecto(
                        titulo = "Línea 2 del Metro de Lima",
                        descripcion = "Impulso a la construcción de la Línea 2 del Metro y nuevas líneas de transporte masivo.",
                        fecha = "2023",
                        estado = EstadoProyecto.EN_DEBATE
                    ),
                    Proyecto(
                        titulo = "Plan de Seguridad Ciudadana",
                        descripcion = "Propuesta de modernización de serenazgo y seguridad en Lima.",
                        fecha = "2024",
                        estado = EstadoProyecto.PRESENTADO
                    )
                ),
                fuenteOficial = "https://www.jne.gob.pe",
                asistencia = null
            ),

            // 2. Keiko Fujimori - Fuerza Popular
            Candidato(
                id = "candidato_2",
                nombre = "Keiko",
                apellido = "Fujimori",
                edad = 49,
                partidoPolitico = "Fuerza Popular",
                cargo = Cargo.PRESIDENCIA,
                region = "Lima",
                biografia = "Lideresa de Fuerza Popular y candidata presidencial en 2011, 2016 y 2021. Hija del expresidente Alberto Fujimori. Se perfila como posible candidata para las elecciones 2026.",
                denuncias = listOf(
                    Denuncia(
                        titulo = "Caso Odebrecht",
                        descripcion = "Investigación fiscal por presunto lavado de activos relacionado con aportes de Odebrecht a campañas electorales.",
                        fecha = "2018",
                        tipo = TipoDenuncia.PENAL,
                        estado = EstadoDenuncia.EN_PROCESO
                    ),
                    Denuncia(
                        titulo = "Obstrucción a la justicia",
                        descripcion = "Acusación por presunta obstrucción a la justicia en el marco de investigaciones fiscales.",
                        fecha = "2020",
                        tipo = TipoDenuncia.PENAL,
                        estado = EstadoDenuncia.EN_PROCESO
                    )
                ),
                proyectos = listOf(
                    Proyecto(
                        titulo = "Programa Económico Nacional",
                        descripcion = "Propuesta de reactivación económica y generación de empleo.",
                        fecha = "2024",
                        estado = EstadoProyecto.PRESENTADO
                    )
                ),
                fuenteOficial = "https://www.jne.gob.pe",
                asistencia = null
            ),

            // 3. Julio Guzmán - Partido Morado
            Candidato(
                id = "candidato_3",
                nombre = "Julio",
                apellido = "Guzmán",
                edad = 55,
                partidoPolitico = "Partido Morado",
                cargo = Cargo.PRESIDENCIA,
                region = "Lima",
                biografia = "Economista y político peruano. Fundador del Partido Morado. Candidato presidencial en 2016 y 2021. Propone un modelo de centro progresista con énfasis en educación y tecnología.",
                denuncias = emptyList(),
                proyectos = listOf(
                    Proyecto(
                        titulo = "Reforma Educativa Integral",
                        descripcion = "Propuesta de modernización del sistema educativo con enfoque en tecnología y calidad docente.",
                        fecha = "2024",
                        estado = EstadoProyecto.PRESENTADO
                    ),
                    Proyecto(
                        titulo = "Transformación Digital del Estado",
                        descripcion = "Plan para digitalizar servicios públicos y reducir la burocracia.",
                        fecha = "2024",
                        estado = EstadoProyecto.PRESENTADO
                    )
                ),
                fuenteOficial = "https://www.jne.gob.pe",
                asistencia = null
            ),

            // 4. Verónika Mendoza - Nuevo Perú
            Candidato(
                id = "candidato_4",
                nombre = "Verónika",
                apellido = "Mendoza",
                edad = 44,
                partidoPolitico = "Nuevo Perú",
                cargo = Cargo.PRESIDENCIA,
                region = "Cusco",
                biografia = "Psicóloga y política de izquierda. Candidata presidencial en 2016 y 2021. Defensora de los derechos humanos, el medio ambiente y los pueblos indígenas. Probable candidata para 2026.",
                denuncias = emptyList(),
                proyectos = listOf(
                    Proyecto(
                        titulo = "Nueva Constitución",
                        descripcion = "Propuesta de Asamblea Constituyente para elaborar una nueva Constitución Política.",
                        fecha = "2024",
                        estado = EstadoProyecto.PRESENTADO
                    ),
                    Proyecto(
                        titulo = "Protección Ambiental",
                        descripcion = "Plan de protección de la Amazonía y recursos naturales.",
                        fecha = "2024",
                        estado = EstadoProyecto.PRESENTADO
                    ),
                    Proyecto(
                        titulo = "Consulta Previa Vinculante",
                        descripcion = "Fortalecimiento del derecho de consulta previa de comunidades indígenas.",
                        fecha = "2023",
                        estado = EstadoProyecto.EN_DEBATE
                    )
                ),
                fuenteOficial = "https://www.jne.gob.pe",
                asistencia = null
            ),

            // 5. Daniel Urresti - Podemos Perú
            Candidato(
                id = "candidato_5",
                nombre = "Daniel",
                apellido = "Urresti",
                edad = 62,
                partidoPolitico = "Podemos Perú",
                cargo = Cargo.PRESIDENCIA,
                region = "Lima",
                biografia = "General en retiro y político peruano. Congresista actual y posible candidato presidencial 2026. Conocido por su postura de mano dura en seguridad ciudadana. Fue ministro del Interior.",
                denuncias = listOf(
                    Denuncia(
                        titulo = "Caso Hugo Bustíos",
                        descripcion = "Absuelto en segunda instancia por el caso del asesinato del periodista Hugo Bustíos en 1988.",
                        fecha = "2022",
                        tipo = TipoDenuncia.PENAL,
                        estado = EstadoDenuncia.ARCHIVADO
                    )
                ),
                proyectos = listOf(
                    Proyecto(
                        titulo = "Plan Nacional de Seguridad",
                        descripcion = "Propuesta de seguridad ciudadana con presencia militar en calles.",
                        fecha = "2024",
                        estado = EstadoProyecto.PRESENTADO
                    )
                ),
                fuenteOficial = "https://www.jne.gob.pe",
                asistencia = 85
            ),

            // 6. George Forsyth - Somos Perú
            Candidato(
                id = "candidato_6",
                nombre = "George",
                apellido = "Forsyth",
                edad = 42,
                partidoPolitico = "Somos Perú",
                cargo = Cargo.PRESIDENCIA,
                region = "Lima",
                biografia = "Exfutbolista profesional y político. Fue alcalde de La Victoria y candidato presidencial en 2021. Se perfila nuevamente para las elecciones 2026 con un discurso centrado en seguridad y juventud.",
                denuncias = emptyList(),
                proyectos = listOf(
                    Proyecto(
                        titulo = "Perú Seguro",
                        descripcion = "Programa integral de seguridad ciudadana basado en su experiencia en La Victoria.",
                        fecha = "2024",
                        estado = EstadoProyecto.PRESENTADO
                    ),
                    Proyecto(
                        titulo = "Empleos para Jóvenes",
                        descripcion = "Plan de generación de empleo juvenil y capacitación técnica.",
                        fecha = "2024",
                        estado = EstadoProyecto.PRESENTADO
                    )
                ),
                fuenteOficial = "https://www.jne.gob.pe",
                asistencia = null
            ),

            // 7. Hernando de Soto - Avanza País
            Candidato(
                id = "candidato_7",
                nombre = "Hernando",
                apellido = "de Soto",
                edad = 83,
                partidoPolitico = "Avanza País",
                cargo = Cargo.PRESIDENCIA,
                region = "Lima",
                biografia = "Economista de renombre internacional. Autor de 'El Misterio del Capital'. Candidato presidencial en 2021. Su candidatura para 2026 depende de su estado de salud y decisión partidaria.",
                denuncias = emptyList(),
                proyectos = listOf(
                    Proyecto(
                        titulo = "Formalización Empresarial",
                        descripcion = "Plan masivo de formalización de pequeñas empresas y viviendas informales.",
                        fecha = "2024",
                        estado = EstadoProyecto.PRESENTADO
                    ),
                    Proyecto(
                        titulo = "Titulación de Tierras",
                        descripcion = "Programa de titulación rápida de propiedades urbanas y rurales.",
                        fecha = "2024",
                        estado = EstadoProyecto.PRESENTADO
                    )
                ),
                fuenteOficial = "https://www.jne.gob.pe",
                asistencia = null
            ),

            // 8. César Acuña - Alianza para el Progreso
            Candidato(
                id = "candidato_8",
                nombre = "César",
                apellido = "Acuña",
                edad = 75,
                partidoPolitico = "Alianza para el Progreso",
                cargo = Cargo.PRESIDENCIA,
                region = "La Libertad",
                biografia = "Empresario educativo y político. Fundador de la Universidad César Vallejo y del partido APP. Candidato presidencial en 2016 y 2021. Posible candidato para 2026.",
                denuncias = listOf(
                    Denuncia(
                        titulo = "Plagio académico",
                        descripcion = "Acusaciones de plagio en tesis doctoral, que llevaron a sanciones académicas.",
                        fecha = "2016",
                        tipo = TipoDenuncia.ADMINISTRATIVA,
                        estado = EstadoDenuncia.SENTENCIADO
                    )
                ),
                proyectos = listOf(
                    Proyecto(
                        titulo = "Plataforma Educativa Nacional",
                        descripcion = "Propuesta de reforma universitaria y expansión de educación superior.",
                        fecha = "2024",
                        estado = EstadoProyecto.PRESENTADO
                    ),
                    Proyecto(
                        titulo = "Obras por Impuestos Ampliado",
                        descripcion = "Expansión del mecanismo de obras por impuestos a nivel nacional.",
                        fecha = "2024",
                        estado = EstadoProyecto.EN_DEBATE
                    )
                ),
                fuenteOficial = "https://www.jne.gob.pe",
                asistencia = null
            ),

            // 9. Antauro Humala - A.N.T.A.U.R.O
            Candidato(
                id = "candidato_9",
                nombre = "Antauro",
                apellido = "Humala",
                edad = 61,
                partidoPolitico = "A.N.T.A.U.R.O",
                cargo = Cargo.PRESIDENCIA,
                region = "Lima",
                biografia = "Militar retirado y político etnocacerista. Liberado de prisión en 2024 tras cumplir condena por el Andahuaylazo. Inscribió su partido y se perfila como candidato presidencial 2026 con un discurso nacionalista radical.",
                denuncias = listOf(
                    Denuncia(
                        titulo = "Andahuaylazo",
                        descripcion = "Cumplió condena de 19 años por rebelión, secuestro y homicidio en el levantamiento de Andahuaylas (2005).",
                        fecha = "2009",
                        tipo = TipoDenuncia.PENAL,
                        estado = EstadoDenuncia.SENTENCIADO
                    )
                ),
                proyectos = listOf(
                    Proyecto(
                        titulo = "Nacionalización de Recursos",
                        descripcion = "Propuesta de nacionalización de recursos naturales estratégicos.",
                        fecha = "2024",
                        estado = EstadoProyecto.PRESENTADO
                    ),
                    Proyecto(
                        titulo = "Estado Plurinacional",
                        descripcion = "Transformación del Estado hacia un modelo plurinacional.",
                        fecha = "2024",
                        estado = EstadoProyecto.PRESENTADO
                    )
                ),
                fuenteOficial = "https://www.jne.gob.pe",
                asistencia = null
            ),

            // 10. Yonhy Lescano - Acción Popular
            Candidato(
                id = "candidato_10",
                nombre = "Yonhy",
                apellido = "Lescano",
                edad = 63,
                partidoPolitico = "Acción Popular",
                cargo = Cargo.PRESIDENCIA,
                region = "Ayacucho",
                biografia = "Abogado y político veterano. Congresista en múltiples períodos. Candidato presidencial en 2021 donde quedó tercero. Posible candidato para 2026 representando a Acción Popular.",
                denuncias = emptyList(),
                proyectos = listOf(
                    Proyecto(
                        titulo = "Ley Anticorrupción Integral",
                        descripcion = "Propuesta de reforma del sistema judicial y endurecimiento de penas por corrupción.",
                        fecha = "2024",
                        estado = EstadoProyecto.EN_DEBATE
                    ),
                    Proyecto(
                        titulo = "Descentralización Efectiva",
                        descripcion = "Plan de transferencia real de competencias y recursos a gobiernos regionales.",
                        fecha = "2024",
                        estado = EstadoProyecto.PRESENTADO
                    )
                ),
                fuenteOficial = "https://www.jne.gob.pe",
                asistencia = null
            )
        )
    }

    fun getCandidatoById(id: String): Candidato? {
        return getCandidatosEjemplo().find { it.id == id }
    }

    fun getCandidatosPorCargo(cargo: Cargo): List<Candidato> {
        return getCandidatosEjemplo().filter { it.cargo == cargo }
    }

    fun getCandidatosPorPartido(partido: String): List<Candidato> {
        return getCandidatosEjemplo().filter {
            it.partidoPolitico.contains(partido, ignoreCase = true)
        }
    }

    fun getCandidatosPorRegion(region: String): List<Candidato> {
        return getCandidatosEjemplo().filter {
            it.region.contains(region, ignoreCase = true)
        }
    }
}
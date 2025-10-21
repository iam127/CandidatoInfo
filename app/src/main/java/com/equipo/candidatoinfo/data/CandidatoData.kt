package com.equipo.candidatoinfo.data

import com.equipo.candidatoinfo.model.*

object CandidatoData {

    fun getCandidatosEjemplo(): List<Candidato> {
        return listOf(
            // 1. Keiko Fujimori - Fuerza Popular
            Candidato(
                id = "candidato_1",
                nombre = "Keiko",
                apellido = "Fujimori",
                edad = 48,
                partidoPolitico = "Fuerza Popular",
                cargo = Cargo.CONGRESO,
                region = "Lima",
                biografia = "Política peruana, hija del expresidente Alberto Fujimori. Lideró Fuerza Popular y ha sido candidata presidencial en tres ocasiones.",
                denuncias = listOf(
                    Denuncia(
                        titulo = "Caso Odebrecht",
                        descripcion = "Investigación por presunto lavado de activos relacionado con aportes de Odebrecht a su campaña electoral.",
                        fecha = "2018",
                        tipo = TipoDenuncia.PENAL,
                        estado = EstadoDenuncia.EN_PROCESO
                    ),
                    Denuncia(
                        titulo = "Obstrucción a la justicia",
                        descripcion = "Acusación por presunta obstrucción a la justicia en el marco del caso Odebrecht.",
                        fecha = "2020",
                        tipo = TipoDenuncia.PENAL,
                        estado = EstadoDenuncia.EN_PROCESO
                    )
                ),
                proyectos = emptyList(),
                fuenteOficial = "https://www.jne.gob.pe"
            ),

            // 2. Verónika Mendoza - Juntos por el Perú
            Candidato(
                id = "candidato_2",
                nombre = "Verónika",
                apellido = "Mendoza",
                edad = 43,
                partidoPolitico = "Juntos por el Perú",
                cargo = Cargo.CONGRESO,
                region = "Cusco",
                biografia = "Psicóloga y política peruana. Candidata presidencial en 2016 y 2021. Defensora de los derechos humanos y el medio ambiente.",
                denuncias = emptyList(),
                proyectos = listOf(
                    Proyecto(
                        titulo = "Ley de Consulta Previa",
                        descripcion = "Proyecto para fortalecer el derecho de consulta previa de las comunidades indígenas.",
                        fecha = "2019",
                        estado = EstadoProyecto.PRESENTADO
                    ),
                    Proyecto(
                        titulo = "Reforma Agraria",
                        descripcion = "Propuesta de reforma agraria para pequeños agricultores.",
                        fecha = "2020",
                        estado = EstadoProyecto.EN_DEBATE
                    )
                ),
                fuenteOficial = "https://www.jne.gob.pe",
                asistencia = 92
            ),

            // 3. Rafael López Aliaga - Renovación Popular
            Candidato(
                id = "candidato_3",
                nombre = "Rafael",
                apellido = "López Aliaga",
                edad = 60,
                partidoPolitico = "Renovación Popular",
                cargo = Cargo.PRESIDENCIA,
                region = "Lima",
                biografia = "Empresario peruano, actual alcalde de Lima. Conocido por su postura conservadora y católica.",
                denuncias = listOf(
                    Denuncia(
                        titulo = "Cuestionamientos éticos",
                        descripcion = "Denuncias por supuestos conflictos de interés en gestión municipal.",
                        fecha = "2023",
                        tipo = TipoDenuncia.ADMINISTRATIVA,
                        estado = EstadoDenuncia.EN_PROCESO
                    )
                ),
                proyectos = listOf(
                    Proyecto(
                        titulo = "Túnel Santa Rosa",
                        descripcion = "Proyecto de infraestructura vial en Lima.",
                        fecha = "2023",
                        estado = EstadoProyecto.EN_DEBATE
                    )
                ),
                fuenteOficial = "https://www.jne.gob.pe"
            ),

            // 4. Hernando de Soto - Avanza País
            Candidato(
                id = "candidato_4",
                nombre = "Hernando",
                apellido = "de Soto",
                edad = 82,
                partidoPolitico = "Avanza País",
                cargo = Cargo.PRESIDENCIA,
                region = "Lima",
                biografia = "Economista peruano de renombre internacional. Autor de 'El Misterio del Capital' y defensor de la propiedad privada.",
                denuncias = emptyList(),
                proyectos = listOf(
                    Proyecto(
                        titulo = "Formalización de Propiedad",
                        descripcion = "Iniciativa para formalizar la propiedad de viviendas informales.",
                        fecha = "2021",
                        estado = EstadoProyecto.PRESENTADO
                    )
                ),
                fuenteOficial = "https://www.jne.gob.pe",
                asistencia = null
            ),

            // 5. César Acuña - Alianza Para el Progreso (APP)
            Candidato(
                id = "candidato_5",
                nombre = "César",
                apellido = "Acuña",
                edad = 74,
                partidoPolitico = "Alianza Para el Progreso",
                cargo = Cargo.CONGRESO,
                region = "La Libertad",
                biografia = "Empresario y político peruano. Fundador de la Universidad César Vallejo y del partido APP.",
                denuncias = listOf(
                    Denuncia(
                        titulo = "Plagio académico",
                        descripcion = "Acusaciones de plagio en trabajos académicos.",
                        fecha = "2016",
                        tipo = TipoDenuncia.ADMINISTRATIVA,
                        estado = EstadoDenuncia.ARCHIVADO
                    ),
                    Denuncia(
                        titulo = "Infracción electoral",
                        descripcion = "Multa por infracciones electorales en campaña.",
                        fecha = "2016",
                        tipo = TipoDenuncia.ADMINISTRATIVA,
                        estado = EstadoDenuncia.SENTENCIADO
                    )
                ),
                proyectos = listOf(
                    Proyecto(
                        titulo = "Ley de Universidades",
                        descripcion = "Propuesta de reforma del sistema universitario.",
                        fecha = "2018",
                        estado = EstadoProyecto.RECHAZADO
                    )
                ),
                fuenteOficial = "https://www.jne.gob.pe",
                asistencia = 78
            ),

            // 6. Yonhy Lescano - Acción Popular
            Candidato(
                id = "candidato_6",
                nombre = "Yonhy",
                apellido = "Lescano",
                edad = 62,
                partidoPolitico = "Acción Popular",
                cargo = Cargo.CONGRESO,
                region = "Ayacucho",
                biografia = "Abogado y político peruano. Congresista en varios períodos y defensor de causas sociales.",
                denuncias = listOf(
                    Denuncia(
                        titulo = "Denuncia por difamación",
                        descripcion = "Proceso por presunta difamación en declaraciones públicas.",
                        fecha = "2019",
                        tipo = TipoDenuncia.CIVIL,
                        estado = EstadoDenuncia.ARCHIVADO
                    )
                ),
                proyectos = listOf(
                    Proyecto(
                        titulo = "Ley de Protección Animal",
                        descripcion = "Iniciativa para proteger los derechos de los animales.",
                        fecha = "2020",
                        estado = EstadoProyecto.APROBADO
                    ),
                    Proyecto(
                        titulo = "Ley contra la Corrupción",
                        descripcion = "Propuesta de endurecimiento de penas por corrupción.",
                        fecha = "2021",
                        estado = EstadoProyecto.EN_DEBATE
                    )
                ),
                fuenteOficial = "https://www.jne.gob.pe",
                asistencia = 88
            ),

            // 7. George Forsyth - Somos Perú
            Candidato(
                id = "candidato_7",
                nombre = "George",
                apellido = "Forsyth",
                edad = 41,
                partidoPolitico = "Somos Perú",
                cargo = Cargo.CONGRESO,
                region = "Lima",
                biografia = "Exfutbolista y político peruano. Fue alcalde de La Victoria y candidato presidencial en 2021.",
                denuncias = emptyList(),
                proyectos = listOf(
                    Proyecto(
                        titulo = "Seguridad Ciudadana",
                        descripcion = "Programa de mejora de seguridad ciudadana en distritos.",
                        fecha = "2019",
                        estado = EstadoProyecto.APROBADO
                    )
                ),
                fuenteOficial = "https://www.jne.gob.pe",
                asistencia = null
            ),

            // 8. Alberto Fujimori - Fuerza Popular
            Candidato(
                id = "candidato_8",
                nombre = "Alberto",
                apellido = "Fujimori",
                edad = 85,
                partidoPolitico = "Fuerza Popular",
                cargo = Cargo.PRESIDENCIA,
                region = "Lima",
                biografia = "Expresidente del Perú (1990-2000). Actualmente cumple condena por violaciones de derechos humanos.",
                denuncias = listOf(
                    Denuncia(
                        titulo = "Caso Barrios Altos",
                        descripcion = "Condena por homicidio calificado y lesiones graves en masacre de Barrios Altos.",
                        fecha = "2009",
                        tipo = TipoDenuncia.PENAL,
                        estado = EstadoDenuncia.SENTENCIADO
                    ),
                    Denuncia(
                        titulo = "Caso La Cantuta",
                        descripcion = "Condena por secuestro agravado y homicidio calificado.",
                        fecha = "2009",
                        tipo = TipoDenuncia.PENAL,
                        estado = EstadoDenuncia.SENTENCIADO
                    ),
                    Denuncia(
                        titulo = "Diarios Chicha",
                        descripcion = "Condena por peculado en caso de los diarios chicha.",
                        fecha = "2015",
                        tipo = TipoDenuncia.PENAL,
                        estado = EstadoDenuncia.SENTENCIADO
                    )
                ),
                proyectos = emptyList(),
                fuenteOficial = "https://www.jne.gob.pe"
            ),

            // 9. Pedro Castillo - Perú Libre
            Candidato(
                id = "candidato_9",
                nombre = "Pedro",
                apellido = "Castillo",
                edad = 54,
                partidoPolitico = "Perú Libre",
                cargo = Cargo.PRESIDENCIA,
                region = "Cajamarca",
                biografia = "Profesor rural y expresidente del Perú (2021-2022). Vacado por el Congreso y actualmente en prisión preventiva.",
                denuncias = listOf(
                    Denuncia(
                        titulo = "Organización Criminal",
                        descripcion = "Investigación por presunta organización criminal y corrupción.",
                        fecha = "2022",
                        tipo = TipoDenuncia.PENAL,
                        estado = EstadoDenuncia.EN_PROCESO
                    ),
                    Denuncia(
                        titulo = "Obstrucción a la justicia",
                        descripcion = "Acusación por obstrucción a las investigaciones fiscales.",
                        fecha = "2023",
                        tipo = TipoDenuncia.PENAL,
                        estado = EstadoDenuncia.EN_PROCESO
                    )
                ),
                proyectos = listOf(
                    Proyecto(
                        titulo = "Reforma Educativa",
                        descripcion = "Propuesta de mejora del sistema educativo nacional.",
                        fecha = "2021",
                        estado = EstadoProyecto.PRESENTADO
                    )
                ),
                fuenteOficial = "https://www.jne.gob.pe"
            ),

            // 10. Antauro Humala - A.N.T.A.U.R.O
            Candidato(
                id = "candidato_10",
                nombre = "Antauro",
                apellido = "Humala",
                edad = 60,
                partidoPolitico = "A.N.T.A.U.R.O",
                cargo = Cargo.PRESIDENCIA,
                region = "Lima",
                biografia = "Militar retirado y político peruano. Hermano del expresidente Ollanta Humala. Líder del movimiento etnocacerista.",
                denuncias = listOf(
                    Denuncia(
                        titulo = "Andahuaylazo",
                        descripcion = "Condena por rebelión, secuestro y homicidio en el levantamiento de Andahuaylas (2005).",
                        fecha = "2009",
                        tipo = TipoDenuncia.PENAL,
                        estado = EstadoDenuncia.SENTENCIADO
                    ),
                    Denuncia(
                        titulo = "Apología al terrorismo",
                        descripcion = "Investigación por presunta apología al terrorismo en declaraciones públicas.",
                        fecha = "2023",
                        tipo = TipoDenuncia.PENAL,
                        estado = EstadoDenuncia.EN_PROCESO
                    )
                ),
                proyectos = emptyList(),
                fuenteOficial = "https://www.jne.gob.pe"
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
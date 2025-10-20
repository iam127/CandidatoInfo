package com.equipo.candidatoinfo.data

import com.equipo.candidatoinfo.model.*

object CandidatoData {

    fun getCandidatosEjemplo(): List<Candidato> {
        return listOf(
            // CONGRESISTAS ACTUALES
            Candidato(
                id = "1",
                nombre = "Keiko",
                apellido = "Fujimori Higuchi",
                partidoPolitico = "Fuerza Popular",
                cargo = Cargo.CONGRESO,
                region = "Lima",
                edad = 48,
                fotoUrl = "keiko_fujimori",
                biografia = "Lideresa de Fuerza Popular. Economista y administradora por la Universidad de Boston. Hija del ex presidente Alberto Fujimori. Ha sido candidata presidencial en 2011, 2016 y 2021.",
                fuenteOficial = "https://www.congreso.gob.pe",
                denuncias = listOf(
                    Denuncia(
                        id = "d1",
                        titulo = "Investigación por lavado de activos",
                        descripcion = "Proceso judicial por presunto lavado de activos relacionado con aportes de campaña de Odebrecht.",
                        fecha = "15 de octubre, 2018",
                        estado = EstadoDenuncia.EN_PROCESO,
                        tipo = TipoDenuncia.PENAL,
                        fuenteUrl = "https://www.pj.gob.pe"
                    ),
                    Denuncia(
                        id = "d2",
                        titulo = "Obstrucción a la justicia",
                        descripcion = "Investigación fiscal por presunta obstrucción a la justicia en caso Odebrecht.",
                        fecha = "10 de marzo, 2020",
                        estado = EstadoDenuncia.EN_PROCESO,
                        tipo = TipoDenuncia.PENAL,
                        fuenteUrl = "https://www.pj.gob.pe"
                    )
                ),
                proyectos = emptyList(),
                asistencia = null
            ),

            Candidato(
                id = "2",
                nombre = "Verónika",
                apellido = "Mendoza Frisch",
                partidoPolitico = "Juntos por el Perú",
                cargo = Cargo.CONGRESO,
                region = "Cusco",
                edad = 43,
                fotoUrl = "veronika_mendoza",
                biografia = "Psicóloga social y política peruana. Ex congresista (2011-2016). Candidata presidencial en 2016 y 2021. Fundadora del Movimiento Nuevo Perú.",
                fuenteOficial = "https://www.jne.gob.pe",
                denuncias = emptyList(),
                proyectos = listOf(
                    Proyecto(
                        id = "p1",
                        titulo = "Ley de consulta previa a pueblos indígenas",
                        descripcion = "Proyecto para fortalecer el derecho a la consulta previa de comunidades indígenas en proyectos extractivos.",
                        fecha = "20 de julio, 2014",
                        estado = EstadoProyecto.APROBADO,
                        fuenteUrl = "https://www.congreso.gob.pe"
                    ),
                    Proyecto(
                        id = "p2",
                        titulo = "Reforma del sistema de salud",
                        descripcion = "Propuesta para crear un sistema único de salud universal y gratuito.",
                        fecha = "15 de mayo, 2015",
                        estado = EstadoProyecto.ARCHIVADO,
                        fuenteUrl = "https://www.congreso.gob.pe"
                    )
                ),
                asistencia = null
            ),

            Candidato(
                id = "3",
                nombre = "Rafael",
                apellido = "López Aliaga",
                partidoPolitico = "Renovación Popular",
                cargo = Cargo.PRESIDENCIA,
                region = "Lima",
                edad = 60,
                fotoUrl = "rafael_lopez_aliaga",
                biografia = "Empresario peruano, alcalde de Lima desde 2023. Ingeniero industrial por la Universidad de Lima. Fundador de Renovación Popular. Candidato presidencial en 2021.",
                fuenteOficial = "https://www.munlima.gob.pe",
                denuncias = listOf(
                    Denuncia(
                        id = "d3",
                        titulo = "Investigación por discriminación",
                        descripcion = "Denuncia ante organismos de derechos humanos por declaraciones consideradas discriminatorias.",
                        fecha = "5 de marzo, 2021",
                        estado = EstadoDenuncia.ARCHIVADO,
                        tipo = TipoDenuncia.ADMINISTRATIVA,
                        fuenteUrl = "https://www.defensoria.gob.pe"
                    )
                ),
                proyectos = listOf(
                    Proyecto(
                        id = "p3",
                        titulo = "Plan de modernización del transporte en Lima",
                        descripcion = "Implementación de nuevas líneas del Metro de Lima y ordenamiento del transporte público.",
                        fecha = "10 de enero, 2023",
                        estado = EstadoProyecto.EN_DEBATE,
                        fuenteUrl = "https://www.munlima.gob.pe"
                    )
                ),
                asistencia = null
            ),

            Candidato(
                id = "4",
                nombre = "Hernando",
                apellido = "de Soto Polar",
                partidoPolitico = "Avanza País",
                cargo = Cargo.PRESIDENCIA,
                region = "Lima",
                edad = 82,
                fotoUrl = "hernando_de_soto",
                biografia = "Economista peruano de renombre internacional. Presidente del Instituto Libertad y Democracia (ILD). Autor de 'El Otro Sendero' y 'El Misterio del Capital'. Candidato presidencial en 2021.",
                fuenteOficial = "https://www.jne.gob.pe",
                denuncias = emptyList(),
                proyectos = listOf(
                    Proyecto(
                        id = "p4",
                        titulo = "Ley de formalización de la propiedad",
                        descripcion = "Propuesta para facilitar la titulación de predios y formalización de empresas.",
                        fecha = "12 de agosto, 2021",
                        estado = EstadoProyecto.PRESENTADO,
                        fuenteUrl = "https://www.congreso.gob.pe"
                    )
                ),
                asistencia = null
            ),

            Candidato(
                id = "5",
                nombre = "César",
                apellido = "Acuña Peralta",
                partidoPolitico = "Alianza para el Progreso",
                cargo = Cargo.CONGRESO,
                region = "La Libertad",
                edad = 74,
                fotoUrl = "cesar_acuna",
                biografia = "Empresario y político peruano. Fundador de la Universidad César Vallejo. Ex alcalde de Trujillo (2007-2014) y gobernador regional de La Libertad (2019-2022). Candidato presidencial en 2016 y 2021.",
                fuenteOficial = "https://www.jne.gob.pe",
                denuncias = listOf(
                    Denuncia(
                        id = "d4",
                        titulo = "Plagio en tesis doctoral",
                        descripcion = "Investigación por presunto plagio en su tesis doctoral. Universidad Complutense de Madrid anuló su título.",
                        fecha = "18 de febrero, 2016",
                        estado = EstadoDenuncia.SENTENCIADO,
                        tipo = TipoDenuncia.ADMINISTRATIVA,
                        fuenteUrl = "https://www.sunedu.gob.pe"
                    ),
                    Denuncia(
                        id = "d5",
                        titulo = "Compra de terrenos con recursos públicos",
                        descripcion = "Investigación por presunta adquisición irregular de terrenos durante su gestión como gobernador.",
                        fecha = "22 de mayo, 2020",
                        estado = EstadoDenuncia.EN_PROCESO,
                        tipo = TipoDenuncia.PENAL,
                        fuenteUrl = "https://www.pj.gob.pe"
                    )
                ),
                proyectos = listOf(
                    Proyecto(
                        id = "p5",
                        titulo = "Ley de promoción de universidades privadas",
                        descripcion = "Proyecto para flexibilizar requisitos de licenciamiento universitario.",
                        fecha = "30 de noviembre, 2019",
                        estado = EstadoProyecto.RECHAZADO,
                        fuenteUrl = "https://www.congreso.gob.pe"
                    )
                ),
                asistencia = 78.5
            ),

            Candidato(
                id = "6",
                nombre = "Yonhy",
                apellido = "Lescano Ancieta",
                partidoPolitico = "Acción Popular",
                cargo = Cargo.CONGRESO,
                region = "Puno",
                edad = 71,
                fotoUrl = "yonhy_lescano",
                biografia = "Abogado y político peruano. Congresista en diversos períodos desde 2001. Ex ministro de Defensa (2011-2012). Candidato presidencial en 2021.",
                fuenteOficial = "https://www.congreso.gob.pe",
                denuncias = listOf(
                    Denuncia(
                        id = "d6",
                        titulo = "Acoso sexual",
                        descripcion = "Denuncia por presunto acoso sexual a periodista. Caso archivado por prescripción.",
                        fecha = "8 de marzo, 2021",
                        estado = EstadoDenuncia.ARCHIVADO,
                        tipo = TipoDenuncia.PENAL,
                        fuenteUrl = "https://www.pj.gob.pe"
                    )
                ),
                proyectos = listOf(
                    Proyecto(
                        id = "p6",
                        titulo = "Ley de protección de recursos hídricos",
                        descripcion = "Proyecto para proteger fuentes de agua de la contaminación minera.",
                        fecha = "25 de septiembre, 2022",
                        estado = EstadoProyecto.EN_DEBATE,
                        fuenteUrl = "https://www.congreso.gob.pe"
                    ),
                    Proyecto(
                        id = "p7",
                        titulo = "Reforma de las Fuerzas Armadas",
                        descripcion = "Modernización y reforma del sistema de defensa nacional.",
                        fecha = "14 de abril, 2023",
                        estado = EstadoProyecto.PRESENTADO,
                        fuenteUrl = "https://www.congreso.gob.pe"
                    )
                ),
                asistencia = 82.0
            ),

            Candidato(
                id = "7",
                nombre = "George",
                apellido = "Forsyth Sommer",
                partidoPolitico = "Somos Perú",
                cargo = Cargo.CONGRESO,
                region = "Lima",
                edad = 41,
                fotoUrl = "george_forsyth",
                biografia = "Ex futbolista profesional y político peruano. Ex alcalde de La Victoria (2019-2021). Candidato presidencial en 2021.",
                fuenteOficial = "https://www.jne.gob.pe",
                denuncias = emptyList(),
                proyectos = listOf(
                    Proyecto(
                        id = "p8",
                        titulo = "Plan de seguridad ciudadana municipal",
                        descripcion = "Propuesta para mejorar la seguridad en distritos mediante cámaras y mayor presencia policial.",
                        fecha = "5 de junio, 2020",
                        estado = EstadoProyecto.APROBADO,
                        fuenteUrl = "https://www.munivictoria.gob.pe"
                    )
                ),
                asistencia = null
            ),

            Candidato(
                id = "8",
                nombre = "Alberto",
                apellido = "Fujimori Fujimori",
                partidoPolitico = "Fuerza Popular",
                cargo = Cargo.PRESIDENCIA,
                region = "Lima",
                edad = 86,
                fotoUrl = "alberto_fujimori",
                biografia = "Ex presidente del Perú (1990-2000). Ingeniero agrónomo por la Universidad Nacional Agraria La Molina. Cumplió condena por violaciones a derechos humanos y corrupción. Indultado en diciembre de 2023.",
                fuenteOficial = "https://www.jne.gob.pe",
                denuncias = listOf(
                    Denuncia(
                        id = "d7",
                        titulo = "Caso Barrios Altos y La Cantuta",
                        descripcion = "Condenado a 25 años de prisión por homicidio calificado y lesiones graves. Sentenciado como autor mediato de las masacres.",
                        fecha = "7 de abril, 2009",
                        estado = EstadoDenuncia.SENTENCIADO,
                        tipo = TipoDenuncia.PENAL,
                        fuenteUrl = "https://www.pj.gob.pe"
                    ),
                    Denuncia(
                        id = "d8",
                        titulo = "Corrupción y peculado",
                        descripcion = "Condenado por apropiación de fondos públicos para pago de sobornos y medios de comunicación.",
                        fecha = "30 de septiembre, 2009",
                        estado = EstadoDenuncia.SENTENCIADO,
                        tipo = TipoDenuncia.PENAL,
                        fuenteUrl = "https://www.pj.gob.pe"
                    ),
                    Denuncia(
                        id = "d9",
                        titulo = "Esterilizaciones forzadas",
                        descripcion = "Investigación por crímenes de lesa humanidad relacionados con programa de esterilizaciones forzadas en los años 90.",
                        fecha = "20 de noviembre, 2021",
                        estado = EstadoDenuncia.EN_PROCESO,
                        tipo = TipoDenuncia.PENAL,
                        fuenteUrl = "https://www.pj.gob.pe"
                    )
                ),
                proyectos = emptyList(),
                asistencia = null
            ),

            Candidato(
                id = "9",
                nombre = "Pedro",
                apellido = "Castillo Terrones",
                partidoPolitico = "Perú Libre",
                cargo = Cargo.PRESIDENCIA,
                region = "Cajamarca",
                edad = 54,
                fotoUrl = "pedro_castillo",
                biografia = "Ex presidente del Perú (julio 2021 - diciembre 2022). Profesor rural y sindicalista. Su gobierno terminó tras intento de golpe de estado y fue vacado por el Congreso. Actualmente en prisión preventiva.",
                fuenteOficial = "https://www.jne.gob.pe",
                denuncias = listOf(
                    Denuncia(
                        id = "d10",
                        titulo = "Rebelión y conspiración",
                        descripcion = "Proceso penal por intento de golpe de estado al intentar disolver el Congreso el 7 de diciembre de 2022.",
                        fecha = "7 de diciembre, 2022",
                        estado = EstadoDenuncia.EN_PROCESO,
                        tipo = TipoDenuncia.PENAL,
                        fuenteUrl = "https://www.pj.gob.pe"
                    ),
                    Denuncia(
                        id = "d11",
                        titulo = "Organización criminal",
                        descripcion = "Investigación por presunta organización criminal, tráfico de influencias y colusión agravada.",
                        fecha = "15 de enero, 2023",
                        estado = EstadoDenuncia.EN_PROCESO,
                        tipo = TipoDenuncia.PENAL,
                        fuenteUrl = "https://www.pj.gob.pe"
                    )
                ),
                proyectos = listOf(
                    Proyecto(
                        id = "p9",
                        titulo = "Asamblea Constituyente",
                        descripcion = "Propuesta para convocar a una Asamblea Constituyente y redactar nueva Constitución.",
                        fecha = "28 de julio, 2021",
                        estado = EstadoProyecto.RECHAZADO,
                        fuenteUrl = "https://www.congreso.gob.pe"
                    )
                ),
                asistencia = null
            ),

            Candidato(
                id = "10",
                nombre = "Antauro",
                apellido = "Humala Tasso",
                partidoPolitico = "Alianza Nacional de Trabajadores",
                cargo = Cargo.PRESIDENCIA,
                region = "Lima",
                edad = 61,
                fotoUrl = "antauro_humala",
                biografia = "Ex militar y político peruano. Hermano del ex presidente Ollanta Humala. Líder del movimiento etnocacerista. Cumplió condena de 19 años por el 'Andahuaylazo' (2005). Liberado en agosto de 2022.",
                fuenteOficial = "https://www.jne.gob.pe",
                denuncias = listOf(
                    Denuncia(
                        id = "d12",
                        titulo = "Rebelión y homicidio (Andahuaylazo)",
                        descripcion = "Condenado a 19 años de prisión por liderar levantamiento armado en Andahuaylas donde murieron 4 policías.",
                        fecha = "1 de enero, 2005",
                        estado = EstadoDenuncia.SENTENCIADO,
                        tipo = TipoDenuncia.PENAL,
                        fuenteUrl = "https://www.pj.gob.pe"
                    ),
                    Denuncia(
                        id = "d13",
                        titulo = "Apología del terrorismo",
                        descripcion = "Investigación por declaraciones consideradas apología del terrorismo y violación de derechos humanos.",
                        fecha = "10 de septiembre, 2023",
                        estado = EstadoDenuncia.EN_PROCESO,
                        tipo = TipoDenuncia.PENAL,
                        fuenteUrl = "https://www.pj.gob.pe"
                    )
                ),
                proyectos = emptyList(),
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
        return getCandidatosEjemplo().filter { it.partidoPolitico == partido }
    }

    fun getCandidatosPorRegion(region: String): List<Candidato> {
        return getCandidatosEjemplo().filter { it.region == region }
    }
}
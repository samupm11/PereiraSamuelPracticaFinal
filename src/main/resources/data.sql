INSERT INTO equipo (id, nombre, pais) VALUES
(1, 'Koi', 'España'),
(2, 'Il Server', 'Italia'),
(3, 'Meigas Clan', 'España');

INSERT INTO jugador (id, nombre, nacionalidad, arquetipo_Favorito, equipo_id) VALUES
(1, 'Alex Gomez', 'España', 'BALANCE', 1),
(2, 'Eric Rios', 'España', 'OFFENSIVE', 1),
(3, 'Samuel Pereira', 'España', 'BALANCE', 3),
(4, 'Marco Silva', 'Italia', 'SUN', 2),
(5, 'Federico Camporesi', 'Italia', 'RAIN', 2),
(6, 'Wolfey Glick', 'Estados Unidos', 'PERISH_SONG', NULL),
(7, 'Giovanni Cischke', 'Estados Unidos', 'SUN', NULL);

INSERT INTO torneo (id, nombre, lugar, tipo, max_jugadores) VALUES
(1, 'World Championships 2025', 'Anaheim, Estados Unidos', 'MUNDIAL', 512),
(2, 'Sevilla Special Event 2025', 'Sevilla, España', 'SPECIAL', 1024),
(3, 'Europe International Championship 2025', 'Londres, Reino Unido', 'INTERNATIONAL', 1300);

INSERT INTO torneo_jugador (torneo_id, jugador_id) VALUES
(1, 1), (1, 2), (1, 3), (1, 4), (1, 5), (1, 6), (1, 7);

INSERT INTO torneo_jugador (torneo_id, jugador_id) VALUES
(2, 2), (2, 3);

INSERT INTO torneo_jugador (torneo_id, jugador_id) VALUES
(3, 1), (3, 2), (3, 3), (3, 4), (3, 5), (3, 6), (3, 7);

INSERT INTO resultado_torneo (jugador_id, torneo_id, posicion_final, puntos_obtenidos, premio_cantidad, premio_moneda) VALUES
(7, 1, 1, 0, 30000, 'USD'),   
(6, 1, 32, 0, 0, 'USD'),      
(1, 1, 256, 0, 0, 'USD'),       
(2, 1, 256, 0, 0, 'USD'),       
(3, 1, 256, 0, 0, 'USD'),       
(4, 1, 256, 0, 0, 'USD'),      
(5, 1, 256, 0, 0, 'USD');       

INSERT INTO resultado_torneo (jugador_id, torneo_id, posicion_final, puntos_obtenidos, premio_cantidad, premio_moneda) VALUES
(3, 2, 6, 280, 0, 'EUR'),    
(2, 2, 32, 120, 0, 'EUR');       

INSERT INTO resultado_torneo (jugador_id, torneo_id, posicion_final, puntos_obtenidos, premio_cantidad, premio_moneda) VALUES
(6, 3, 1, 500, 15000, 'USD'),   
(1, 3, 128, 0, 0, 'USD'),      
(2, 3, 128, 0, 0, 'USD'),     
(3, 3, 128, 0, 0, 'USD'), 
(4, 3, 128, 0, 0, 'USD'),     
(5, 3, 128, 0, 0, 'USD'),     
(7, 3, 128, 0, 0, 'USD');      
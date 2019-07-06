<h1>**Тестовое задание Java EE**</h1>

<h2>**Список действий и структура запросов:**</h2>

1) добавить почтовые отделения (пример RequestBody можно взять из папки requests/postaloffice.json (обрабатывается только один объект))
<br>
method: POST path: /office

2) добавить почтовое отправление (пример RequestBody можно взять из папки requests/mailing.json)
<br>
method: POST path: /mailing

3) Манипулировать почтовым отправлением ( 
    1. отправление в другие почтовые отделения <br>
    method: POST path: /history/departed/{id почтового отправления} + RequestBody index другого почтового отделения (пример requests/history.json)
    
    2. забирать посылки <br>
    method: POST path: /history/received/{id почтового отправления}
    
    3. доставлять в почтовые отделения <br>
    method: POST path: /history/arrived/{id почтового отправления}
    
    4. просматривать историю движения почтового отправления) <br>
    method: GET path: /history/get/{id почтового отправления}
    
    5. увидеть все почтовые отправления <br>
    method: GET path: /history/all)

P.S. <br>
Отказоустойчивость во многих случаях не предусмотрена.
За индексами лучше следить в БД: localhost:8080/h2-console

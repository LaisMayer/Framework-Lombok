
# Testes da API

##  Testes para Travel

### Criar viagem

**POST** `http://localhost:8080/travels`


**Body JSON:**

```json
{
  "passengerId": 10,
  "origin": "Centro",
  "destination": "loja"
}
```

* JSON esperado:

```json
{
  "id": 1,
  "passengerId": 10,
  "origin": "Centro",
  "destination": "Shopping",
  "status": "CREATED"
}
```


### Aceitar a viagem

**PATCH** `http://localhost:8080/travels/1/accept`

```json
{
  "id": 1,
  "status": "ACCEPTED"
}
```

### Erro: aceitar viagem já ACCEPTED

**PATCH** `http://localhost:8080/travels/1/accept`

* Status: 400

```json
{
  "status": 400,
  "message": "Viagem já aceita ou finalizada"
}
```


### Erro: id não existe

**PATCH** `http://localhost:8080/travels/999/accept`

**Esperado:** 404 Not Found
 

##  Testes para Driver

###  Criar driver válido

**POST** `http://localhost:8080/drivers`

**Body JSON:**

```json
{
  "name": "Lais",
  "cpf": "123.456.789-09",
  "email": "lais@email.com",
  "birthDate": "1990-05-10",
  "placa": "ABC1D23",
  "cnh": "12345678900",
  "anoCarro": 2019,
  "comentario": "Carro novo",
  "num": 11
}
```

**Esperado:** 200 com id criado


### Erro: comentário proibido

**Body JSON:**

```json
{
  "name": "Joao",
  "cpf": "123.456.789-09",
  "email": "joao@email.com",
  "birthDate": "1995-10-10",
  "placa": "ABC1D23",
  "cnh": "12345678900",
  "anoCarro": 2020,
  "comentario": "seu carro é um lixo",
  "num": 11
}
```

**Esperado:** 400 Bad Request


### Erro: email inválido

**Body JSON:**

```json
{
  "name": "Lais Mayer",
  "cpf": "123.456.789-09",
  "email": "emailerrado",
  "birthDate": "2000-10-10",
  "placa": "ABC1D23",
  "cnh": "12345678900",
  "anoCarro": 2020,
  "comentario": "tudo certo",
  "num": 7
}
```


### Erro: nome com espaços

**Body JSON:**

```json
{
  "name": "La is",
  "cpf": "123.456.789-09",
  "email": "laismayer@gmail.com",
  "birthDate": "2008-10-10",
  "placa": "ABC1D23",
  "cnh": "12345678900",
  "anoCarro": 2020,
  "comentario": "ok",
  "num": 5
}
```

## Testes para Passenger 


###  Criar Passenger 

**POST** `http://localhost:8080/passengers`

**Body JSON:**

```json
 {
  "name": "Maria",
  "email": "maria@gmail.com",
  "cpf": "123.456.789-09"

}
```


### Erro: nome com espaço

```json
{
  "name": "Lais Mayer",
  "email": "maria@gmail.com",
  "cpf": "123.456.789-09"
}
```

**Esperado:** 400
Mensagem: "O nome não pode conter espaços em branco"


### Erro: CPF inválido 

```json
{
  "name": "Lais",
  "email": "laismayer@gmail.com",
  "cpf": "11111111111" 
}
```


### Erro: email inválido 

```json
{
  "name": "Lais",
  "email": "email_invalido",
  "cpf": "123.456.789-09"
}
```

### Atualização parcial (PATCH)

**PATCH** `http://localhost:8080/passengers/1`

**Body JSON:**

```json
{
  "email": "novoemail@gmail.com"
}
```

### Atualização completa

**PUT** `http://localhost:8080/passengers/1`

**Body JSON:**

```json
{
  "name": "Lais",
  "email": "laismayer@gmail.com",
  "cpf": "123.456.789-09"
}
```

**Esperado:** válido segundo regras atuais


### Deletar Passenger

**DELETE** `http://localhost:8080/passengers/1`
**Esperado:** 200 OK



### Deletar Passenger inexistente

**DELETE** `http://localhost:8080/passengers/9999`
**Esperado:** 404 Not Found
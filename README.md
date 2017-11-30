# TrabJavaSwing
Trabalho prático Swing e JDBC para disciplica de LPOO TADS UFPR 2017

## Requisitos para executar
* Java instalado (JDK completo, esse software foi feito com Java 8) 
* Netbeans (Foi usado o 8.2)
* MySql Workbench (Foi usado o 6.3)
* MySql Server (Foi usado o 5.5)

## Criação do banco de dados
* A senha do usuário *root* do mysql é *root*
* Execute o método DAOGeral.Criarbanco(true) para criar o banco de dados
* Ou este script para o db e as tabelas:
```
CREATE DATABASE db_proj;
USE db_proj;
CREATE TABLE tb_cliente( idCliente INT(64) NOT NULL AUTO_INCREMENT PRIMARY KEY , nomeCliente VARCHAR(100),sobrenomeCliente VARCHAR(100), telefoneCliente INT);
CREATE TABLE tb_pedido( idPedido INT(64) NOT NULL AUTO_INCREMENT PRIMARY KEY , nomePedido VARCHAR(100),statusPedido VARCHAR(100));
```
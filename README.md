# Processo Seletivo

## Descrição do Projeto

Este projeto é uma simulação de um sistema de processo seletivo para uma empresa. Ele avalia candidatos com base em seus salários pretendidos em comparação com o salário base oferecido pela empresa, seleciona candidatos para entrevista e realiza tentativas de contato para agendar entrevistas.

## Funcionalidades

- Geração de candidatos com salários aleatórios entre R$1800,00 e R$2200,00.
- Seleção de até 5 candidatos com salário pretendido menor ou igual ao salário base (R$2000,00).
- Impressão da lista de candidatos selecionados para entrevista.
- Realização de até 3 tentativas de contato com cada candidato selecionado.
- Impressão do resultado das tentativas de contato.

## Requisitos

- Java 8 ou superior

## Como Rodar o Projeto

1. **Clone o repositório**
    ```bash
    git clone https://github.com/seu-usuario/processo-seletivo.git
    cd processo-seletivo
    ```

2. **Compile o projeto**
    ```bash
    javac src/main/java/com/empresa/processoseletivo/*.java
    ```

3. **Execute o projeto**
    ```bash
    java -cp src/main/java com.empresa.processoseletivo.ProcessoSeletivo
    ```


## Como Contribuir

1. **Fork o projeto**
2. **Crie uma nova branch**
    ```bash
    git checkout -b minha-feature
    ```
3. **Faça suas alterações e commit**
    ```bash
    git commit -m "Minha nova feature"
    ```
4. **Envie suas alterações**
    ```bash
    git push origin minha-feature
    ```
5. **Abra um Pull Request**

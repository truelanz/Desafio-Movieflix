


## _Casos de uso do sistema_

>### **Listar filmes:**
1. Lista de nomes de todos os gêneros. 
2. Lista (Paginada) com título, subtítulo, ano e imagem. Ordenada (asc) por título.
3. Visitante ou Membro pode selecionar (opcional) um gênero.
4. O sistema apresenta a listagem (paginada) atualizada, restrigindo-se ao gênero selecionado:
    - ...`/movies?genreId=0&page=0&size=4`
    - Se genreId = 0, mostra todos os gêneros.

>### **Detalhes do filme**
1. O sistema informa título, subtítulo, ano, imagem e sinopse do filme.
2. Mostra uma listagem dos textos das avaliações daquele filme juntamente com nome do usuário que fez cada avaliação.
3. O usuário (membro) informa, opcionalmente, um texto para avaliação do filme.
4. O sistema apresenta os dados atualizados, já aparecendo também a avaliação feita pelo usuário.
5. **Exceção** - O sistema apresenta uma mensagem de que não é permitido texto vazio na avaliação.

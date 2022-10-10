

<h4 align="center">O Star Wars Movies é uma aplicação simples e intuitiva que te permite visualizar alguns filmes da franquia. 


<p align="center">
  <a href="#ferramentas">Ferramentas</a> -
  <a href="#features">Features</a> -
  <a href="#como-usar">Como usar</a> -
  <a href="#feedback">Feedback</a> -
  <a href="#autor">Autor</a> -
  <a href="#licença">Licença</a>
</p>


## Ferramentas

O aplicativo foi criado com as seguintes ferramentas:

* MVVM
    > O MVVM é uma peça fundamental da arquitetura desse app. Com ele consigo tratar efeitos do ciclo de vida do android, mantenho o binding da view com os dados atualizados e também me proporciona mais facilidade na hora de criar os testes unitários. 
* Koin
    > Optei por utilizar o koin como framework para injeção de dependência pela sua facilidade de implementação e também pela minha experiência anterior com ele.
* LiveData e MutableLiveData
    > Utilizo esses observáveis por serem lifecycle-aware, pois isso garante que a atualização seja feita só nos componentes que estão ativos no clico de vida.

* Mockk
  >  Escolhi o mockk por ser escrito em Kotlin e, por consequência, suportar extensions, final classes, singleton e outras coisas que facilitam mockar os recursos para testes mais sustentáveis.

* Coroutines e Flow
  > Para lidar com chamadas assíncronas escolhi usar as coroutines que facilitam bastante nosso dia a dia por não bloquar a thread em que executamos uma operação mas sim dar a possibilidade de suspender a operação a qualquer momento.
  Seguindo no mesmo pensamento, escolhi usar Flow por ter total suporte as `suspend functions` e também por conseguir lidar melhor com o stream de dados sequenciais assíncronamente.
* Retrofit
  > De longe é a biblioteca de networking que tive mais contato e também é a que vejo sendo mais usada pela comunidade. Escolhi usá-la nesse projeto por ser simples de usar, basicamente só preciso dizer a URL e o que/como eu espero essa resposta (que no meu caso estou lidando com o Gson). Além disso tudo, a documentação é ótima e a comunidade é enorme. 
* Glide
  > Além de ser uma biblioteca recomendada pelo Google, gosto muito praticidade ao usar o glide. Por exemplo, neste app eu consegui deixar a imagem em um shape circular sem muitos problemas, apenas chamando um método ao fazer o setup da imagem. Também confesso que essa é a biblioteca que tive maior tempo de experiência usando.
## Features

Aqui algumas coisas que você já pode encontrar nesse app:

* Visualizar lista de filmes da star wars


## Como usar

* Faça o clone do repositório
  * `$ git clone git@github.com:rafaelsouza-develop/android_challenge.git`
* Abra o app no android studio e faça as sincronizações necessárias
* De um checkout na branch **develop**
* Faça o build do app
* O app vai ser instalado no seu dispositivo ou no emulador
* Aproveite :tada:


## Feedback

Sinta-se a vontade para abrir uma [issue](https://github.com/rafaelsouza-develo/github-app/issues/new) com dúvidas e/ou sugestões!


## Autor

[Rafael Souza]

---

## Licença

MIT License

Copyright (c) 2022 Rafael Souza

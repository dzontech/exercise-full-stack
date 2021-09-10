import React from 'react';
import RestClient from './RestClient';


export default function App() {
  return (
    <React.Fragment>

      <div>Kliknite na dugman da povucete podatke sa servera (vidite u konzoli)</div>
      <button onClick={() => demo1()}>Klikni za sve vesti</button>
      <button onClick={() => demo2()}>Klikni za prvu vest</button>
      <button onClick={() => demo3()}>Klikni za unos komentara</button>
      <button onClick={() => demo4()}>Klikni da obrises 4 komentar</button>
    </React.Fragment>
  );
}


function demo1() {
  const promise = RestClient.getVesti()
  promise.then(data => console.log(`Sve vesti: ${JSON.stringify(data)}`))
}

async function demo2() {
  const data = await RestClient.getVest(1)
  console.log(`Prva vest: ${JSON.stringify(data)}`)
}

async function demo3() {
  const aComment = {ocena: 5, tekst: 'FANTASTICNO', osoba: 'PERA'}
  const addResponse = await RestClient.addComment(2, aComment)
  console.log(addResponse)
}

async function demo4() {
 const addResponse =  await RestClient.deleteComment(4)
 console.log(addResponse)
}



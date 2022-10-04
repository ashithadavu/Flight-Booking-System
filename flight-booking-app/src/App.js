import React from 'react';

import Webpages from './components/Webpages';
import ButtonAppBar from './components/ButtonAppBar';
import './App.css';

function App() {
  return (
    <div className='App'>
      <div className='topbar'>
        <ButtonAppBar/>
      </div>
      <Webpages />
    </div>
  );
}

export default App;

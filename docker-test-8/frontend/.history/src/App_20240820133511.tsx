import { useEffect, useState } from "react";
import "./App.css";

function App() {
  const [text, setText] = useState("");

  useEffect(() => {
    fetch("http://localhost/api/healthcheck")
      .then((res) => res.json())
      .then((data) => {
        setText(data);
      });
  }, []);

  return (
    <>
      <p>{text}</p>
    </>
  );
}

export default App;

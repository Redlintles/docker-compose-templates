import { useEffect, useState } from "react";
import reactLogo from "./assets/react.svg";
import viteLogo from "/vite.svg";
import "./App.css";

function App() {
  const [count, setCount] = useState(0);
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

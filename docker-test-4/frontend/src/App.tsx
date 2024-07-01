import { useEffect, useState } from "react";
import "./App.css";

function App() {
  const [result, setResult] = useState<string[]>([]);

  console.log(`Frontend running at port ${import.meta.env.VITE_PORT}`);
  console.log("API_URL", import.meta.env.VITE_API_URL);

  async function query() {
    const apiUrl = import.meta.env.VITE_API_URL || "http://localhost/api/";
    const fetchResult = await fetch(apiUrl).then((response) => {
      console.log(response);
      return response.json();
    });

    console.log("Hello World!");

    console.log(fetchResult);

    if (fetchResult) {
      setResult(fetchResult.data);
    }
  }

  useEffect(() => {
    query();
  }, []);

  console.log("result check", typeof result, result);

  return (
    <>
      {result && result.map((item, index) => <h1 key={index}>{item}</h1>)}
      <h1>Hello World!</h1>
    </>
  );
}

export default App;

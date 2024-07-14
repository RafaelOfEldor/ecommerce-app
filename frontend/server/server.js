import express from "express";
import * as path from "path";
import bodyParser from "body-parser";
import cookieParser from "cookie-parser";
import dotenv from "dotenv";
import { WebSocketServer } from "ws";

dotenv.config();

const app = express();

app.use(bodyParser.json());
app.use(cookieParser(process.env.SECRET_COOKIE));

async function fetchJson(url, params) {
  const res = await fetch(url, params);
  if (!res.ok) {
    return null;
  }
  return await res.json();
}

// const mongoClient = new MongoClient(process.env.MONGODB_URL);
// mongoClient.connect().then(async () => {
//   app.use(
//     "/api/auth",
//     AuthenticationRouter(mongoClient.db("chat-application-database")),
//   );
//   app.use(
//     "/api/users",
//     UsersRouter(mongoClient.db("chat-application-database")),
//   );
//   app.use(
//     "/api/chats",
//     ChatRouter(mongoClient.db("chat-application-database")),
//   );
// });

app.use(express.static("../client/dist"));

app.use((req, res, next) => {
  if (req.method === "GET" && !req.path.startsWith("/api")) {
    res.sendFile(path.resolve("../client/dist/index.html"));
  } else {
    next();
  }
});

const webSocketServer = new WebSocketServer({ noServer: true });

const server = app.listen(process.env.PORT || 3000, () => {
  console.log(`Running on http://localhost:${server.address().port}`);
});
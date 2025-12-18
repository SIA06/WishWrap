<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gift Shop | Sign Up</title>

    <!-- Stylish fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&family=Pacifico&display=swap" rel="stylesheet">

    <style>
        /* -------- BODY & BACKGROUND -------- */
        body {
            margin: 0;
            padding: 0;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            background: linear-gradient(to bottom, #b3d9c3, #87cefa);
            font-family: 'Poppins', sans-serif;
            overflow: hidden;
        }

        /* -------- SIGNUP BOX -------- */
        .container {
            width: 360px;
            padding: 30px;
            background-color: #f0fff0;
            border-radius: 20px;
            text-align: center;
            box-shadow: 0 10px 30px rgba(0,0,0,0.25);
            position: relative;
            z-index: 2;
        }

        h2 {
            font-size: 30px;
            font-family: 'Baskerville Old Face', serif;
            color: #355E3B;
            margin-bottom: 20px;
        }

        /* -------- INPUT BOXES -------- */
        .input-box {
            margin: 12px 0;
            position: relative;
        }

        .input-box input {
            width: 85%;
            padding: 10px 35px 10px 12px;
            font-size: 14px;
            color: purple;
            border-radius: 10px;
            border: 1px solid #ccc;
            outline: none;
            background: rgba(255,255,255,0.95);
            box-shadow: 0 2px 6px rgba(0,0,0,0.1);
            font-family: 'Century Schoolbook', serif;
            font-weight: 500;
            transition: 0.3s;
        }

        .input-box input:focus {
            border-color: #8858f5;
            box-shadow: 0 2px 8px rgba(136,88,245,0.4);
        }

        .input-box i {
            position: absolute;
            right: 12px;
            top: 50%;
            transform: translateY(-50%);
            font-size: 18px;
        }

        .input-box input::placeholder {
            color: #20b2aa;
            font-family: 'Comic Sans MS', cursive, sans-serif;
            font-weight: 500;
        }

        /* -------- BUTTON -------- */
        button {
            width: 100%;
            padding: 12px;
            border-radius: 12px;
            background: linear-gradient(135deg, #ff84b3, #8858f5);
            border: none;
            color: white;
            font-size: 18px;
            font-family: 'Maiandra GD', serif;
            font-weight: 600;
            cursor: pointer;
            box-shadow: 0 5px 15px rgba(0,0,0,0.25);
            transition: 0.3s;
            margin-top: 10px;
        }

        button:hover {
            transform: scale(1.05);
        }

        /* -------- MESSAGE -------- */
        #message {
            margin-top: 12px;
            font-weight: 500;
            font-size: 15px;
        }

        /* -------- ALREADY SIGNED-UP OPTIONS -------- */
        .options {
            margin-top: 20px;
            text-align: left;
            font-family: 'Century Schoolbook', serif;
            font-size: 14px;
        }

        .options a {
            text-decoration: none;
            color: #191970;
            font-weight: 600;
            transition: 0.3s;
        }

        .options a:hover {
            color: #8858f5;
            transform: translateX(5px);
        }

        /* -------- FLOATING EMOJIS -------- */
        .emoji {
            position: absolute;
            font-size: 42px;
            animation: float 6s infinite ease-in-out;
            opacity: 0.25;
        }

        .emoji1 { top: 15%; left: 5%; }
        .emoji2 { top: 25%; left: 75%; }
        .emoji3 { top: 70%; left: 8%; }
        .emoji4 { top: 60%; left: 55%; }
        .emoji5 { top: 75%; left: 70%; }
        .emoji6 { top: 65%; left: 90%; }
        .emoji7 { top: 45%; left: 21%; }

        @keyframes float {
            0%   { transform: translateY(0); }
            50%  { transform: translateY(-22px); }
            100% { transform: translateY(0); }
        }
    </style>
</head>

<body>

    <!-- Floating emojis -->
    <div class="emoji emoji1">🎁</div>
    <div class="emoji emoji2">🎀</div>
    <div class="emoji emoji3">🎀</div>
    <div class="emoji emoji4">🎀</div>
    <div class="emoji emoji5">🎁</div>
    <div class="emoji emoji6">🛍</div>
    <div class="emoji emoji7">🛍</div>

    <div class="container">
        <h2>SIGN-UP</h2>

        <div class="input-box">
            <input type="text" id="name" placeholder="Full Name">
            <i>👤</i>
        </div>

        <div class="input-box">
            <input type="email" id="email" placeholder="Email Address">
            <i>📧</i>
        </div>

        <div class="input-box">
            <input type="text" id="username" placeholder="Username">
            <i>🧑‍💻</i>
        </div>

        <div class="input-box">
            <input type="password" id="password" placeholder="Password">
            <i>🔒</i>
        </div>

        <div class="input-box">
            <input type="tel" id="phone" placeholder="Phone Number">
            <i>📞</i>
        </div>

        <div class="input-box">
            <input type="text" id="question" placeholder="Security Question">
            <i>❓</i>
        </div>

        <div class="input-box">
            <input type="text" id="answer" placeholder="Answer">
            <i>💡</i>
        </div>

        <button onclick="signUp()">Sign Up</button>

        <p id="message"></p>

        <div class="options">
            * Already have an account?
            <a href="login.html">Login</a>
        </div>
    </div>

    <script>
        function signUp() {
            let name = document.getElementById("name").value;
            let email = document.getElementById("email").value;
            let username = document.getElementById("username").value;
            let password = document.getElementById("password").value;
            let phone = document.getElementById("phone").value;
            let question = document.getElementById("question").value;
            let answer = document.getElementById("answer").value;
            let message = document.getElementById("message");

            if (!name || !email || !username || !password || !phone || !question || !answer) {
                message.style.color = "red";
                message.innerText = "⚠ Please fill all fields!";
            } else {
                message.style.color = "green";
                message.innerText = "✔ Account Created Successfully!";
            }
        }
    </script>

</body>
</html>
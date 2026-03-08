package com.fotova.service.html;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class StripeHtmlDevService implements StripeHtmlService {
    public String buildSuccessHtml() {

        return """
        <!DOCTYPE html>
                    <html>
                    <head>
                    <meta charset="UTF-8">
                    <title>Paiement réussi</title>
                    <meta http-equiv="refresh" content="5;url=http://localhost/success">
                    <style>
                        body {
                            font-family: -apple-system, BlinkMacSystemFont, sans-serif;
                            background: #f6f9fc;
                            display: flex;
                            justify-content: center;
                            align-items: center;
                            height: 100vh;
                            margin: 0;
                        }
                        .card {
                            background: white;
                            padding: 50px;
                            border-radius: 16px;
                            box-shadow: 0 20px 40px rgba(0,0,0,0.08);
                            text-align: center;
                            width: 420px;
                            animation: fadeIn 0.6s ease-in-out;
                        }

                        h1 {
                            margin-top: 20px;
                            font-size: 22px;
                            color: #32325d;
                        }

                        p {
                            color: #6b7c93;
                            margin-top: 10px;
                            font-size: 15px;
                        }

                        .checkmark {
                            width: 80px;
                            height: 80px;
                            border-radius: 50%;
                            display: inline-block;
                            border: 4px solid #4BB543;
                            position: relative;
                            animation: pop 0.4s ease-out forwards;
                            margin: 0 auto;
                        }

                        .checkmark::after {
                            content: '';
                            position: absolute;
                            top: 50%;
                            left: 50%;
                            width: 20px;
                            height: 30px;
                            border-right: 4px solid #4BB543;
                            border-bottom: 4px solid #4BB543;
                            transform: translate(-50%, -50%) rotate(45deg);
                            animation: draw 0.5s ease forwards;
                        }

                        a {
                            display: inline-block;
                            margin-top: 25px;
                            padding: 12px 25px;
                            background: #635bff;
                            color: white;
                            border-radius: 8px;
                            text-decoration: none;
                            font-weight: 600;
                            transition: background 0.2s;
                        }
 
                        a:hover {
                            background: #4f46e5;
                        }
                
                        .countdown {
                            margin-top: 15px;
                            font-size: 13px;
                            color: #8898aa;
                        }
                
                        @keyframes fadeIn {
                            from {opacity: 0; transform: translateY(10px);}
                            to {opacity: 1; transform: translateY(0);}
                        }
                
                        @keyframes pop {
                            from {transform: scale(0.8); opacity: 0;}
                            to {transform: scale(1); opacity: 1;}
                        }
                
                        @keyframes draw {
                            from {opacity: 0;}
                            to {opacity: 1;}
                        }
                    </style>
                    </head>
                    <body>
                
                    <div class="card">
                        <div class="checkmark"></div>
                        <h1>Paiement confirmé 🎉</h1>
                        <p>Merci pour votre commande.</p>
                        <p>Un email avec votre facture vient d’être envoyé.</p>
                        <div class="countdown">
                            Redirection automatique dans <span id="timer">5</span> secondes...
                        </div>
                        <a href="http://localhost/success">
                            Continuer vos achats
                        </a>
                    </div>
                
                    <script>
                        let seconds = 5;
                        const timer = document.getElementById('timer');
                        const interval = setInterval(() => {
                            seconds--;
                            timer.textContent = seconds;
                            if(seconds <= 0) {
                                clearInterval(interval);
                                window.location.href = "http://localhost/success";
                            }
                        }, 1000);
                    </script>
                
                    </body>
                    </html>
    """;
    }

    public String buildFailureHtml() {

        return """
                <!DOCTYPE html>
                <html lang="fr">
                <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Paiement échoué</title>
                
                <style>
                
                body{
                    margin:0;
                    font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Arial, sans-serif;
                    background:#f6f7fb;
                    display:flex;
                    align-items:center;
                    justify-content:center;
                    height:100vh;
                }
                
                .card{
                    background:white;
                    padding:40px;
                    max-width:480px;
                    width:90%;
                    border-radius:14px;
                    box-shadow:0 15px 40px rgba(0,0,0,0.08);
                    text-align:center;
                }
                
                .icon{
                    font-size:60px;
                    margin-bottom:15px;
                }
                
                h1{
                    margin:10px 0;
                    font-size:26px;
                    color:#d32f2f;
                }
                
                p{
                    color:#555;
                    line-height:1.6;
                }
                
                ul{
                    text-align:left;
                    margin:20px 0;
                    padding-left:20px;
                    color:#666;
                }
                
                .buttons{
                    margin-top:25px;
                }
                
                .btn{
                    display:inline-block;
                    padding:12px 22px;
                    border-radius:8px;
                    text-decoration:none;
                    font-weight:600;
                    margin:6px;
                }
                
                .btn-primary{
                    background:#d32f2f;
                    color:white;
                }
                
                .btn-primary:hover{
                    background:#b71c1c;
                }
                
                .btn-secondary{
                    background:#eceff1;
                    color:#333;
                }
                
                .btn-secondary:hover{
                    background:#dfe3e6;
                }
                
                .footer{
                    margin-top:20px;
                    font-size:14px;
                    color:#888;
                }
                
                </style>
                </head>
                
                <body>
                
                <div class="card">
                
                <div class="icon">❌</div>
                
                <h1>Paiement refusé</h1>
                
                <p>
                Nous n'avons pas pu finaliser votre paiement. \s
                Votre commande n'a pas été débitée.
                </p>
                
                <ul>
                <li>Solde insuffisant</li>
                <li>Informations de carte incorrectes</li>
                <li>Validation bancaire refusée</li>
                <li>Problème temporaire avec le moyen de paiement</li>
                </ul>
                
                <div class="buttons">
                                <a href="http://localhost/cart">
                                    Retourner au panier
                                </a>
                </div>
                
                <div class="footer">
                Si le problème persiste, contactez le support.
                </div>
                
                </div>
                
                </body>
                </html>
        """;
    }

    public String buildCancelHtml() {

        return """
        <!DOCTYPE html>
        <html>
        <head>
        <meta charset="UTF-8">
        <title>Paiement annulé</title>
        <meta http-equiv="refresh" content="5;url=http://localhost/cart">
        <style>
            body {
                font-family: -apple-system, BlinkMacSystemFont, sans-serif;
                background: #f6f9fc;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
                margin: 0;
            }
        
            .card {
                background: white;
                padding: 50px;
                border-radius: 16px;
                box-shadow: 0 20px 40px rgba(0,0,0,0.08);
                text-align: center;
                width: 420px;
                animation: fadeIn 0.6s ease-in-out;
            }
        
            h1 {
                margin-top: 20px;
                font-size: 22px;
                color: #32325d;
            }
        
            p {
                color: #6b7c93;
                margin-top: 10px;
                font-size: 15px;
            }
        
            .pause {
                width: 80px;
                height: 80px;
                border-radius: 50%;
                border: 4px solid #ff9800;
                display: flex;
                justify-content: center;
                align-items: center;
                font-size: 30px;
                color: #ff9800;
                animation: pop 0.4s ease-out forwards;
            
                margin: 0 auto;
            }
        
            a {
                display: inline-block;
                margin-top: 25px;
                padding: 12px 25px;
                background: #635bff;
                color: white;
                border-radius: 8px;
                text-decoration: none;
                font-weight: 600;
            }
        
            .countdown {
                margin-top: 15px;
                font-size: 13px;
                color: #8898aa;
            }
        
            @keyframes fadeIn {
                from {opacity: 0; transform: translateY(10px);}
                to {opacity: 1; transform: translateY(0);}
            }
        
            @keyframes pop {
                from {transform: scale(0.8); opacity: 0;}
                to {transform: scale(1); opacity: 1;}
            }
        </style>
        </head>
        <body>
        
        <div class="card">
            <div class="pause">II</div>
            <h1>Paiement annulé</h1>
            <p>Aucun montant n’a été débité.</p>
            <p>Vous pouvez reprendre votre panier à tout moment.</p>
            <div class="countdown">
                Redirection automatique dans <span id="timer">5</span> secondes...
            </div>
            <a href="http://localhost/cart">
                Retourner au panier
            </a>
        </div>
        
        <script>
            let seconds = 5;
            const timer = document.getElementById('timer');
            const interval = setInterval(() => {
                seconds--;
                timer.textContent = seconds;
                if(seconds <= 0) {
                    clearInterval(interval);
                    window.location.href = "http://localhost/cart";
                }
            }, 1000);
        </script>
        
        </body>
        </html>
        """;
    }
}

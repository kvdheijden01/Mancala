import React from "react";
import type { GameState } from "../gameState";
import "./FinalScreen.css";

type PlayProps = {
    gameState: GameState;
    setGameState(newGameState: GameState): void;
}

export function FinalScreen({ gameState, setGameState }: PlayProps) {
    async function playAgain() {

        try {
            const response = await fetch('mancala/api/start', {
                method: 'POST',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({ nameplayer1: gameState.players[0].name, nameplayer2: gameState.players[1].name })
            });

            if (response.ok) {
                const gameState = await response.json();
                setGameState(gameState);
            } else {
                console.error(response.statusText);
            }
        } catch (error) {
            console.error(error);
        }
    }

    return (
        <div>
            <p className = "matchTitle">{gameState.players[0].name} vs {gameState.players[1].name}</p>
            <p className = "winner">Winner: <span className = "winnerName">{gameState.gameStatus.winner}</span></p>
            <div className = "center">
            <button className = "playAgainButton" type = "button" onClick = {() => playAgain()}>Play Again</button>
            </div>
        </div>
    )
}
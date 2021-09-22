import React from "react";
import type { GameState } from "../gameState";
import "./Play.css";

type PlayProps = {
    gameState: GameState;
    setGameState(newGameState: GameState): void;
}

export function Play({ gameState, setGameState }: PlayProps) {
    async function playPit(index:number) {
        let pit = { index: index}
        console.log(pit)
        try {
            const response = await fetch('mancala/api/move', {
                method: 'POST',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(pit)
            });

            if (response.ok) {
                const gameState = await response.json();
                setGameState(gameState);
            } else {
                console.error(response.statusText);
            }
                } catch (error) {
                console.error(error.toString());
                }
    }

    return (
        <div>
            <p>{gameState.players[0].name} vs {gameState.players[1].name}</p>

            <p>Active Player: {}</p>
            <table>
            <tbody>
            <tr>
                <td>&nbsp;</td>
                <td>&nbsp;<button type = "button" onClick = {() => playPit(12)}>{gameState.players[1].pits[5].nrOfStones}</button></td>
                <td>&nbsp;<button type = "button" onClick = {() => playPit(11)}>{gameState.players[1].pits[4].nrOfStones}</button></td>
                <td>&nbsp;<button type = "button" onClick = {() => playPit(10)}>{gameState.players[1].pits[3].nrOfStones}</button></td>
                <td>&nbsp;<button type = "button" onClick = {() => playPit(9)}>{gameState.players[1].pits[2].nrOfStones}</button></td>
                <td>&nbsp;<button type = "button" onClick = {() => playPit(8)}>{gameState.players[1].pits[1].nrOfStones}</button></td>
                <td>&nbsp;<button type = "button" onClick = {() => playPit(7)}>{gameState.players[1].pits[0].nrOfStones}</button></td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td>&nbsp;{gameState.players[1].pits[6].nrOfStones}</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;{gameState.players[0].pits[6].nrOfStones}</td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td>&nbsp;<button type = "button" onClick = {() => playPit(0)}>{gameState.players[0].pits[0].nrOfStones}</button></td>
                <td>&nbsp;<button type = "button" onClick = {() => playPit(1)}>{gameState.players[0].pits[1].nrOfStones}</button></td>
                <td>&nbsp;<button type = "button" onClick = {() => playPit(2)}>{gameState.players[0].pits[2].nrOfStones}</button></td>
                <td>&nbsp;<button type = "button" onClick = {() => playPit(3)}>{gameState.players[0].pits[3].nrOfStones}</button></td>
                <td>&nbsp;<button type = "button" onClick = {() => playPit(4)}>{gameState.players[0].pits[4].nrOfStones}</button></td>
                <td>&nbsp;<button type = "button" onClick = {() => playPit(5)}>{gameState.players[0].pits[5].nrOfStones}</button></td>
                <td>&nbsp;</td>
            </tr>
            </tbody>
            </table>
        </div>
    )
}
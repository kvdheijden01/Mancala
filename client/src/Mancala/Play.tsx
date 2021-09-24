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
            console.error(error);
        }
    }

    function disableButtonsP1() {    
        if (gameState.players[0].hasTurn) {
            return false
        } else if (gameState.players[1].hasTurn) {
            return true
        }
    }

    function disableButtonsP2() {    
        if (gameState.players[1].hasTurn) {
            return false
        } else if (gameState.players[0].hasTurn) {
            return true
        }
    }

    return (
        <div>
            <p className = "matchTitle">{gameState.players[0].name} vs {gameState.players[1].name}</p>
            <p>
            <table className = "center">
            <tbody>
            <tr>
                <td>&nbsp;</td>
                <td>&nbsp;<button className = "moveButton" type = "button" onClick = {() => playPit(12)} disabled = {disableButtonsP2()} >{gameState.players[1].pits[5].nrOfStones}</button></td>
                <td>&nbsp;<button className = "moveButton" type = "button" onClick = {() => playPit(11)} disabled = {disableButtonsP2()}>{gameState.players[1].pits[4].nrOfStones}</button></td>
                <td>&nbsp;<button className = "moveButton" type = "button" onClick = {() => playPit(10)} disabled = {disableButtonsP2()}>{gameState.players[1].pits[3].nrOfStones}</button></td>
                <td>&nbsp;<button className = "moveButton" type = "button" onClick = {() => playPit(9)} disabled = {disableButtonsP2()}>{gameState.players[1].pits[2].nrOfStones}</button></td>
                <td>&nbsp;<button className = "moveButton" type = "button" onClick = {() => playPit(8)} disabled = {disableButtonsP2()}>{gameState.players[1].pits[1].nrOfStones}</button></td>
                <td>&nbsp;<button className = "moveButton" type = "button" onClick = {() => playPit(7)} disabled = {disableButtonsP2()}>{gameState.players[1].pits[0].nrOfStones}</button></td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td>&nbsp;<p className = "Kahala">{gameState.players[1].pits[6].nrOfStones}</p></td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;<p className = "Kahala">{gameState.players[0].pits[6].nrOfStones}</p></td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td>&nbsp;<button className = "moveButton" type = "button" onClick = {() => playPit(0)} disabled = {disableButtonsP1()}>{gameState.players[0].pits[0].nrOfStones}</button></td>
                <td>&nbsp;<button className = "moveButton" type = "button" onClick = {() => playPit(1)} disabled = {disableButtonsP1()}> {gameState.players[0].pits[1].nrOfStones}</button></td>
                <td>&nbsp;<button className = "moveButton" type = "button" onClick = {() => playPit(2)} disabled = {disableButtonsP1()}>{gameState.players[0].pits[2].nrOfStones}</button></td>
                <td>&nbsp;<button className = "moveButton" type = "button" onClick = {() => playPit(3)} disabled = {disableButtonsP1()}>{gameState.players[0].pits[3].nrOfStones}</button></td>
                <td>&nbsp;<button className = "moveButton" type = "button" onClick = {() => playPit(4)} disabled = {disableButtonsP1()}>{gameState.players[0].pits[4].nrOfStones}</button></td>
                <td>&nbsp;<button className = "moveButton" type = "button" onClick = {() => playPit(5)} disabled = {disableButtonsP1()}>{gameState.players[0].pits[5].nrOfStones}</button></td>
                <td>&nbsp;</td>
            </tr>
            </tbody>
            </table>
            </p>
        </div>
    )
}
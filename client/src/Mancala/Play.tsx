import React from "react";
import type { GameState } from "../gameState";
import "./Play.css";

type PlayProps = {
    gameState: GameState;
    setGameState(newGameState: GameState): void;
}

export function Play({ gameState, setGameState }: PlayProps) {
    return (
        <div>
            <p>{gameState.players[0].name} vs {gameState.players[1].name}</p>
            <table>
            <tbody>
            <tr>
                <td>&nbsp;</td>
                <td>&nbsp;{gameState.players[1].pits[5].nrOfStones}</td>
                <td>&nbsp;{gameState.players[1].pits[4].nrOfStones}</td>
                <td>&nbsp;{gameState.players[1].pits[3].nrOfStones}</td>
                <td>&nbsp;{gameState.players[1].pits[2].nrOfStones}</td>
                <td>&nbsp;{gameState.players[1].pits[1].nrOfStones}</td>
                <td>&nbsp;{gameState.players[1].pits[0].nrOfStones}</td>
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
                <td>&nbsp;{gameState.players[0].pits[0].nrOfStones}</td>
                <td>&nbsp;{gameState.players[0].pits[1].nrOfStones}</td>
                <td>&nbsp;{gameState.players[0].pits[2].nrOfStones}</td>
                <td>&nbsp;{gameState.players[0].pits[3].nrOfStones}</td>
                <td>&nbsp;{gameState.players[0].pits[4].nrOfStones}</td>
                <td>&nbsp;{gameState.players[0].pits[5].nrOfStones}</td>
                <td>&nbsp;</td>
            </tr>
            </tbody>
            </table>
        </div>
    )
}
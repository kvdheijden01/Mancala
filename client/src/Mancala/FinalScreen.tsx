import React from "react";
import type { GameState } from "../gameState";

type PlayProps = {
    gameState: GameState;
}

export function FinalScreen({ gameState }: PlayProps) {
    

    return (
        <div>
            <p>{gameState.players[0].name} vs {gameState.players[1].name}</p>
            <p>Winner: {gameState.gameStatus.winner}</p>
        </div>
    )
}
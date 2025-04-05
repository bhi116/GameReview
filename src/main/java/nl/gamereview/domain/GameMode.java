package nl.gamereview.domain;

public enum GameMode {
    SINGLEPLAYER,
    MULTIPLAYER,
    BOTH;

    @Override
        public String toString() {
            String name = name();
            return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        }
}
CREATE TABLE clusters (
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL UNIQUE,
    created_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE notes (
    id SERIAL PRIMARY KEY,
    title TEXT NOT NULL,
    content TEXT NOT NULL,
    cluster_id INTEGER REFERENCES clusters(id) ON DELETE CASCADE,
    parent_note_id INTEGER REFERENCES notes(id) ON DELETE SET NULL,
    created_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_notes_cluster_id ON notes(cluster_id);
CREATE INDEX idx_notes_parent_note_id ON notes(parent_note_id);
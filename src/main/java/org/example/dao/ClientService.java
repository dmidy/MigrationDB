package org.example.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientService {

    private final Map<Long, Client> clients = new HashMap<>();
    private long idCounter = 1;

    public long create(String name) {
        validateName(name);
        long clientId = idCounter++;
        Client client = new Client(clientId, name);
        clients.put(clientId, client);
        return clientId;
    }

    public String getById(long id) {
        validateClientId(id);
        Client client = clients.get(id);
        return (client != null) ? client.getName() : null;
    }

    public void setName(long id, String name) {
        validateClientId(id);
        validateName(name);
        Client client = clients.get(id);
        if (client != null) {
            client.setName(name);
        }
    }

    public void deleteById(long id) {
        validateClientId(id);
        clients.remove(id);
    }

    public List<Client> listAll() {
        return new ArrayList<>(clients.values());
    }

    private void validateName(String name) {
        if (name == null || name.length() < 2 || name.length() > 100) {
            throw new IllegalArgumentException("Invalid name");
        }
    }

    private void validateClientId(long id) {
        if (!clients.containsKey(id)) {
            throw new IllegalArgumentException("Client with given id does not exist");
        }
    }

    public static class Client {
        private final long id;
        private String name;

        public Client(long id, String name) {
            this.id = id;
            this.name = name;
        }

        public long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
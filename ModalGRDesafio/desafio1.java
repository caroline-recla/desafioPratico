class Criptografia {

    private static final String CHAVE_SECRETA = "#modalGR#GPTW#top#maiorEmpresaTecnologia#baixadaSantista";

    public static String criptografarSenha(String senha, int metodoCriptografia) {
        switch (metodoCriptografia) {
            case 1:
                return criptografarSenhaSHA256(senha);
            case 2:
                return criptografarSenhaMD5(senha);
            case 3:
                return criptografarSenhaSaltSHA256(senha);
            default:
                throw new IllegalArgumentException("Método de criptografia inválido.");
        }
    }

    private static String criptografarSenhaSHA256(String senha) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(senha.getBytes());
            return Arrays.toString(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private static String criptografarSenhaMD5(String senha) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(senha.getBytes());
            return Arrays.toString(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private static String criptografarSenhaSaltSHA256(String senha) {
        byte[] salt = CHAVE_SECRETA.getBytes();
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] hash = md.digest(senha.getBytes());
            return Arrays.toString(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class SHA256
{
    private static byte[] hashInBytes = new byte[0];

    public static String sha(String str)
    {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            hashInBytes = md.digest(str.getBytes("UTF-8"));
        }catch (NoSuchAlgorithmException | UnsupportedEncodingException e)
        {
            System.out.println(e.getMessage());
        }
        //bytes to hex
        StringBuilder sb = new StringBuilder();
        for (byte b : hashInBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

}

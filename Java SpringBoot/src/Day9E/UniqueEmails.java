
package day9;

import java.util.List;
import java.util.Set;
import java.util.LinkedHashSet;

public class UniqueEmails {
    public static void main(String[] args) {
        List<String> emails = List.of(
                "a@x.com", "b@x.com", "a@x.com",
                "c@x.com", "b@x.com"
        );

        Set<String> uniqueEmails = new LinkedHashSet<>(emails);

        System.out.println("Unique emails: " + uniqueEmails);

        int duplicatesRemoved = emails.size() - uniqueEmails.size();
        System.out.println("Duplicates removed: " + duplicatesRemoved);
    }
}

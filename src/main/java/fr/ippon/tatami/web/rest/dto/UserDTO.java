package fr.ippon.tatami.web.rest.dto;

import fr.ippon.tatami.domain.User;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.*;
import java.util.Set;
import java.util.stream.Collectors;
/**
 * A DTO representing a user, with his authorities.
 */
public class UserDTO {

    public static final int PASSWORD_MIN_LENGTH = 5;
    public static final int PASSWORD_MAX_LENGTH = 100;

    @Pattern(regexp = "^[a-z0-9]*$")
    @Size(min = 1, max = 50)
    private String username;

    @NotNull
    @Size(min = PASSWORD_MIN_LENGTH, max = PASSWORD_MAX_LENGTH)
    private String password;

    private String avatar;

    @Size(max = 50)
    private String firstName;

    @Size(max = 50)
    private String lastName;

    @NotNull
    @Email
    @Size(min = 5, max = 100)
    private String email;

    @Size(max = 50)
    private String jobTitle;

    @Size(max = 50)
    private String phoneNumber;

    private boolean activated = false;

    @Size(min = 2, max = 5)
    private String langKey;

    private Set<String> authorities;

    private boolean mentionEmail;

    private String rssUid;

    private boolean weeklyDigest;

    private boolean dailyDigest;

    private String domain;

    private long attachmentsSize;

    private boolean you;

    public UserDTO() {
    }

    public UserDTO(User user) {
        this(user.getUsername(), null, user.getAvatar(), user.getFirstName(), user.getLastName(),
            user.getEmail(), user.getActivated(), user.getLangKey(),
            user.getAuthorities(), user.getJobTitle(), user.getPhoneNumber(), user.getMentionEmail(),
            user.getRssUid(), user.getWeeklyDigest(),
            user.getDailyDigest(), user.getDomain());
    }

    public UserDTO(String username, String password, String avatar, String firstName, String lastName,
        String email, boolean activated, String langKey, Set<String> authorities,
                   String jobTitle, String phoneNumber,
                   boolean mentionEmail, String rssUid, boolean weeklyDigest,
        boolean dailyDigest, String domain) {

        this.username = username;
        this.password = password;
        this.avatar = avatar;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.activated = activated;
        this.langKey = langKey;
        this.authorities = authorities;
        this.jobTitle = jobTitle;
        this.phoneNumber = phoneNumber;
        this.mentionEmail = mentionEmail;
        this.rssUid = rssUid;
        this.weeklyDigest = weeklyDigest;
        this.dailyDigest = dailyDigest;
        this.domain = domain;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public String getLangKey() {
        return langKey;
    }

    public void setLangKey(String langKey) {
        this.langKey = langKey;
    }

    public Set<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<String> authorities) {
        this.authorities = authorities;
    }

    public boolean isMentionEmail() {
        return mentionEmail;
    }

    public void setMentionEmail(boolean mentionEmail) {
        this.mentionEmail = mentionEmail;
    }

    public String getRssUid() {
        return rssUid;
    }

    public void setRssUid(String rssUid) {
        this.rssUid = rssUid;
    }

    public boolean isWeeklyDigest() {
        return weeklyDigest;
    }

    public void setWeeklyDigest(boolean weeklyDigest) {
        this.weeklyDigest = weeklyDigest;
    }

    public boolean isDailyDigest() {
        return dailyDigest;
    }

    public void setDailyDigest(boolean dailyDigest) {
        this.dailyDigest = dailyDigest;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public long getAttachmentsSize() {
        return attachmentsSize;
    }

    public void setAttachmentsSize(long attachmentsSize) {
        this.attachmentsSize = attachmentsSize;
    }

    public boolean isYou() {
        return you;
    }

    public void setYou(boolean you) {
        this.you = you;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDTO user = (UserDTO) o;

        return !(username != null ? !username.equals(user.username) : user.username != null);

    }

    public String toString() {
        return "UserDTO{" +
            "username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", avatar='" + avatar + '\'' +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", email='" + email + '\'' +
            ", activated=" + activated +
            ", langKey='" + langKey + '\'' +
            ", authorities=" + authorities + '\'' +
            ", jobTitle='" + jobTitle + '\'' +
            ", phoneNumber='" + phoneNumber + '\'' +
            ", mentionEmail=" + mentionEmail + '\'' +
            ", rssUid=" + rssUid + '\'' +
            ", weeklyDigest=" + weeklyDigest + '\'' +
            ", dailyDigest=" + dailyDigest + '\'' +
            ", domain=" + domain +
            "}";
    }
}

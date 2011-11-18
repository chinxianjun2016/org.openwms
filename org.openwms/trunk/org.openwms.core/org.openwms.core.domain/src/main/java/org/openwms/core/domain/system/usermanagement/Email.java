/*
 * openwms.org, the Open Warehouse Management System.
 *
 * This file is part of openwms.org.
 *
 * openwms.org is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as 
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * openwms.org is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software. If not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.openwms.core.domain.system.usermanagement;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import org.openwms.core.annotation.GlossaryTerm;
import org.openwms.core.domain.AbstractEntity;
import org.openwms.core.domain.DomainObject;
import org.openwms.core.util.validation.AssertUtils;

/**
 * An Email encapsulates the email address of an <code>User</code>.
 * 
 * @author <a href="mailto:scherrer@openwms.org">Heiko Scherrer</a>
 * @version $Revision$
 * @since 0.1
 * @see org.openwms.core.domain.system.usermanagement.User
 */
@GlossaryTerm
@Entity
@Table(name = "COR_EMAIL", uniqueConstraints = @UniqueConstraint(columnNames = { "C_USERNAME", "C_ADDRESS" }))
public class Email extends AbstractEntity implements DomainObject<Long> {

    private static final long serialVersionUID = 3182027866592095069L;

    /**
     * Unique technical key.
     */
    @Id
    @GeneratedValue
    // CHECK [scherrer] : what is this??
    @ManyToOne
    private Long id;

    /**
     * Unique identifier of the <code>Email</code> (not nullable).
     */
    @Column(name = "C_USERNAME", nullable = false)
    private String userName;

    /**
     * The email address as String (not nullable).
     */
    @Column(name = "C_ADDRESS", nullable = false)
    private String emailAddress;

    /**
     * The fullname of the <code>User</code>.
     */
    @Column(name = "C_FULL_NAME")
    private String fullName;

    /**
     * Version field.
     */
    @Version
    @Column(name = "C_VERSION")
    private long version;

    /* ----------------------------- methods ------------------- */
    /**
     * Accessed by persistence provider.
     */
    @SuppressWarnings("unused")
    private Email() {

    }

    /**
     * Create a new <code>Email</code> with an <code>userName</code> and an
     * <code>emailAddress</code>.
     * 
     * @param userName
     *            The name of the User
     * @param emailAddress
     *            The email address of the User
     * @throws IllegalArgumentException
     *             when userName or emailAddress is <code>null</code> or empty
     */
    public Email(String userName, String emailAddress) {
        AssertUtils.isNotEmpty(userName, "Username must not be null or empty");
        AssertUtils.isNotEmpty(emailAddress, "EmailAddress must not be null or empty");
        this.userName = userName;
        this.emailAddress = emailAddress;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long getId() {
        return id;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isNew() {
        return this.id == null;
    }

    /**
     * Returns the name of the <code>User</code> who owns this
     * <code>Email</code>.
     * 
     * @return The userName as String
     */
    public String getUserName() {
        return this.userName;
    }

    /**
     * Assign the <code>Email</code> to an <code>User</code>.
     * 
     * @param userName
     *            Name of the <code>User</code>.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Return the emailAddress.
     * 
     * @return The emailAddress.
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Set the emailAddress.
     * 
     * @param emailAddress
     *            The emailAddress to set.
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * Return the fullName.
     * 
     * @return The fullName.
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Set the fullName.
     * 
     * @param fullName
     *            The fullName to set.
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long getVersion() {
        return version;
    }

    /**
     * Return the emailAddress as String.
     * 
     * @see java.lang.Object#toString()
     * @return the emailAddress
     */
    @Override
    public String toString() {
        return emailAddress;
    }
}
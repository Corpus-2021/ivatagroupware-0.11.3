/*
 * Copyright (c) 2001 - 2005 ivata limited.
 * All rights reserved.
 * -----------------------------------------------------------------------------
 * ivata groupware may be redistributed under the GNU General Public
 * License as published by the Free Software Foundation;
 * version 2 of the License.
 *
 * These programs are free software; you can redistribute them and/or
 * modify them under the terms of the GNU General Public License
 * as published by the Free Software Foundation; version 2 of the License.
 *
 * These programs are distributed in the hope that they will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *
 * See the GNU General Public License in the file LICENSE.txt for more
 * details.
 *
 * If you would like a copy of the GNU General Public License write to
 *
 * Free Software Foundation, Inc.
 * 59 Temple Place - Suite 330
 * Boston, MA 02111-1307, USA.
 *
 *
 * To arrange commercial support and licensing, contact ivata at
 *                  http://www.ivata.com/contact.jsp
 * -----------------------------------------------------------------------------
 * $Log: LibraryRights.java,v $
 * Revision 1.4  2005/04/29 02:48:16  colinmacleod
 * Data bugfixes.
 * Changed primary key back to Integer.
 *
 * Revision 1.3  2005/04/10 20:09:45  colinmacleod
 * Added new themes.
 * Changed id type to String.
 * Changed i tag to em and b tag to strong.
 * Improved PicoContainerFactory with NanoContainer scripts.
 *
 * Revision 1.2  2005/04/09 17:19:46  colinmacleod
 * Changed copyright text to GPL v2 explicitly.
 *
 * Revision 1.1.1.1  2005/03/10 17:51:59  colinmacleod
 * Restructured ivata op around Hibernate/PicoContainer.
 * Renamed ivata groupware.
 *
 * Revision 1.3  2004/11/12 18:16:05  colinmacleod
 * Ordered imports.
 *
 * Revision 1.2  2004/11/12 15:57:16  colinmacleod
 * Removed dependencies on SSLEXT.
 * Moved Persistence classes to ivata masks.
 *
 * Revision 1.1  2004/07/13 19:47:29  colinmacleod
 * Moved project to POJOs from EJBs.
 * Applied PicoContainer to services layer (replacing session EJBs).
 * Applied Hibernate to persistence layer (replacing entity EJBs).
 * -----------------------------------------------------------------------------
 */
package com.ivata.groupware.business.library.right;

import java.util.Collection;

import com.ivata.groupware.admin.security.server.SecuritySession;
import com.ivata.groupware.business.library.comment.CommentDO;
import com.ivata.mask.util.SystemException;

/**
 * <p>
 * TODO: add a comment for this type.
 * </p>
 *
 * @author Colin MacLeod
 * <a href='mailto:colin.macleod@ivata.com'>colin.macleod@ivata.com</a>
 * @since   Jun 19, 2004
 * @version $Revision: 1.4 $
 */

public interface LibraryRights {

    /**
     * <p>
     * This method changes ADD rights. Users in the specified groups will be
     * able to add ITEMS with this TOPIC.
     * </p>
     *
     * <p>
     * It's works only with those groups which can be seen by the user.
     * if I am adding ADD right for a group and the user has not VIEW right
     * -> also create a VIEW right for that group.
     * </p>
     *
     * @param id of TOPIC
     * @param userName user vhich is goin to change rights
     * @param rights collection of groups for which we will set up ADD right
     */
    public abstract void amendAddRightsForItem(SecuritySession securitySession,
            Integer id, Collection rights)
            throws SystemException;

    /**
     * <p>This method changing AMEND rights. Users in those groups will be able to amend ITEMS with this TOPIC.
     * It's working only with those groups which can be see by user.
     * if I am adding AMEND right for group and there is not VIEW right -> so create VIEW right for that group.</p>
     *
     * @param id of TOPIC
     * @param userName user vhich is goin to change rights
     * @param rights collection of groups for which we will set up AMEND right
     */
    public abstract void amendAmendRightsForItem(
            SecuritySession securitySession, Integer id,
            Collection rights) throws SystemException;

    /**
     * <p>This method changing AMEND rights of TOPIC. It's working only with those groups which can be see by user.
     * if I am adding AMEND right for group and there is not VIEW right -> so create VIEW right for that group.</p>
     *
     * @param id of TOPIC
     * @param userName user which is chaning
     * @param rights collection of groups for which we will set up AMEND right
     */
    public abstract void amendAmendRightsForTopic(
            SecuritySession securitySession, Integer id,
            Collection rights) throws SystemException;

    /**
     * <p>This method changing REMOVE rights. Users in those groups will be able to remove ITEMS with this TOPIC.
     * It's working only with those groups which can be see by user.
     * if I am adding REMOVE right for group and there is not VIEW right -> so create VIEW right for that group.</p>
     *
     * @param id of TOPIC
     * @param userName user vhich is goin to change rights
     * @param rights collection of groups for which we will set up REMOVE right
     */
    public abstract void amendRemoveRightsForItem(
            SecuritySession securitySession, Integer id,
            Collection rights) throws SystemException;

    /**
     * <p>This method changing REMOVE rights of TOPIC. It's working only with those groups which can be see by user.
     * if I am adding REMOVE right for group and there is not VIEW right -> so create VIEW right for that group.</p>
     *
     * @param id of TOPIC
     * @param userName user vhich is going to change
     * @param rights collection of groups for which we will set up REMOVE right
     */
    public abstract void amendRemoveRightsForTopic(
            SecuritySession securitySession, Integer id,
            Collection rights) throws SystemException;

    /**
     * <p>This method changing VIEW rights of ITEMS. Users in those groups will be albe to see ITEMS with this TOPIC.
     *  It's working only with those groups which can be see by user.</p>
     *
     * @param id of TOPIC
     * @param userName user vhich is goin to change rights
     * @param rights collection of groups for which we will set up VIEW right
     */
    public abstract void amendViewRightsForItem(
            SecuritySession securitySession, Integer id,
            Collection rights) throws SystemException;

    /**
     * <p>This method changing VIEW rights of TOPIC. It's working only with those groups which can be see by user.</p>
     *
     * @param id of TOPIC
     * @param userName user which is changing
     * @param rights collection of groupIds for which we will set up VIEW right
     */
    public abstract void amendViewRightsForTopic(
            SecuritySession securitySession, Integer id,
            Collection rights) throws SystemException;

    /**
     * <p>Find out if a user is allowed to add a new comment.</p>
     *
     * @param userName the name of the user to check the user rights for.
     * @param comment the comment check.
     * @return <code>true</code> if the user is entitled to add this comment,
     *   otherwise <code>false</code>.
     */
    public abstract boolean canAddComment(SecuritySession securitySession,
            CommentDO comment) throws SystemException;

    /**
     * <p>Find out if a user is allowed to add a new topic.</p>
     *
     * @param userName the name of the user to check the user rights for.
     * @param topicId the unique identifier of the topic to check.
     * @return <code>true</code> if the user is entitled to add new topics,
     *     otherwise <code>false</code>.
     */
    public abstract boolean canAddTopic(SecuritySession securitySession)
            throws SystemException;

    /**
     * <p>Find out if a user is allowed to add items to a given topic.</p>
     *
     * @param userName the name of the user to check the user rights for.
     * @param topicId the unique identifier of the topic to check.
     * @return <code>true</code> if the user is entitled to add items to the
     *      topic, otherwise <code>false</code>.
     */
    public abstract boolean canAddToTopic(SecuritySession securitySession,
            Integer topicId) throws SystemException;

    /**
     * <p>Find out if a user is allowed to change an existing comment.</p>
     *
     * @param userName the name of the user to check the user rights for.
     * @param comment the comment check.
     * @return <code>true</code> if the user is entitled to change this comment,
     *   otherwise <code>false</code>.
     */
    public abstract boolean canAmendComment(SecuritySession securitySession,
            CommentDO comment) throws SystemException;

    /**
     * <p>Find out if a user is allowed to amend items in a given topic.</p>
     *
     * @param userName the name of the user to check the user rights for.
     * @param integerParam the unique identifier of the topic to check.
     * @return <code>true</code> if the user is entitled to amend items in the
     *      topic, otherwise <code>false</code>.
     */
    public abstract boolean canAmendInTopic(SecuritySession securitySession,
            Integer integerParam) throws SystemException;

    /**
     * <p>Find out if a user is allowed to amend an existing new topic.</p>
     *
     * @param userName the name of the user to check the user rights for.
     * @param topicId the unique identifier of the topic to check.
     * @return <code>true</code> if the user is entitled to amend the
     *      topic, otherwise <code>false</code>.
     */
    public abstract boolean canAmendTopic(SecuritySession securitySession,
            Integer id) throws SystemException;

    /**
     * <p>Find out if a user is allowed to remove an existing comment.</p>
     *
     * @param userName the name of the user to check the user rights for.
     * @param comment the comment check.
     * @return <code>true</code> if the user is entitled to remove this comment,
     *   otherwise <code>false</code>.
     */
    public abstract boolean canRemoveComment(SecuritySession securitySession,
            CommentDO comment) throws SystemException;

    /**
     * <p>Find out if a user is allowed to remove items from a given topic.</p>
     *
     * @param userName the name of the user to check the user rights for.
     * @param topicId the unique identifier of the topic to check.
     * @return <code>true</code> if the user is entitled to remove items from
     *      the topic, otherwise <code>false</code>.
     */
    public abstract boolean canRemoveFromTopic(SecuritySession securitySession,
            Integer topicId) throws SystemException;

    /**
     * <p>Find out if a user is allowed to remove a topic.</p>
     *
     * @param userName the name of the user to check the user rights for.
     * @param topicId the unique identifier of the topic to check.
     * @return <code>true</code> if the user is entitled to remove the
     *      topic, otherwise <code>false</code>.
     */
    public abstract boolean canRemoveTopic(SecuritySession securitySession,
            Integer id) throws SystemException;

    /**
     * <p>Internal helper method. Find out if a user is allowed to access
     * entries in a given group.</p>
     *
     * @param securitySession Security session to check the rights for.
     * @param topicId Unique identifier of the topic to check.
     * @param access The access level as defined in {@link
     *      com.ivata.groupware.business.addressbook.person.group.right.RightConstants
     *      RightConstants}.
     * @return <code>true</code> if the user is entitled to access entries in the
     *      topic, otherwise <code>false</code>.
     */
    public abstract boolean canUser(SecuritySession securitySession,
            Integer topicId, Integer detail, Integer access)
            throws SystemException;

    /**
     * <p>Find out if a user is allowed to view items to a given topic.</p>
     *
     * @param userName the name of the user to check the user rights for.
     * @param topicId the unique identifier of the topic to check.
     * @return <code>true</code> if the user is entitled to view items in the
     *      topic, otherwise <code>false</code>.
     */
    public abstract boolean canViewInTopic(SecuritySession securitySession,
            Integer topicId) throws SystemException;

    /**
     * <p>Find groups which have <code>access</code> to items with topic.
     * Return only those groups which can be see by that user.</p>
     *
     * @param id of TOPIC
     * @param userName user which is trying to find rights
     * @param access find rights with this access
     * @return Collection of IDS of groups which have <code>access</code> to that items wuth that topic
     */
    public abstract Collection findRightsForItemsInTopic(
            SecuritySession securitySession, Integer id, Integer access)
            throws SystemException;

    /**
     * <p>Find groups which have <code>access</code> to topic.
     * Return only those groups which can be see by that user.</p>
     *
     * @param id of TOPIC
     * @param userName user which is trying to find rights
     * @param access find rights with this access
     * @return Collection of IDS of groups which have <code>access</code> to that topic
     */
    public abstract Collection findRightsForTopic(
            SecuritySession securitySession, Integer id, Integer access)
            throws SystemException;

    /**
     * <p>Find the unique identifiers of all library topics for which the items
     * can be accessed by the group specified, with the access level given.</p>
     *
     * @param groupId unique identifier of the group for which to search for
     *    library topics.
     * @param access the access level as defined in {@link
     *      com.ivata.groupware.business.addressbook.person.group.right.RightConstants
     *      RightConstants}.
     * @return a <code>Collection</code> of <code>Integer</code> instances,
     *      matching all topics which can be access with this level of access
     *      by the group specified.
     */
    public abstract Collection findTopicsByGroupAccess(
            SecuritySession securitySession,
            Integer groupId,
            Integer access) throws SystemException;
}
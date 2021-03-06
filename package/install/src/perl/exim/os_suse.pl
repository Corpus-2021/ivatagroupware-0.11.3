# emacs mode -*-perl-*-
################################################################################
# $Id: os_suse.pl,v 1.2 2005/04/09 17:19:52 colinmacleod Exp $
#
# This is the site customization file for SuSE-based Linux flavors. It
# overrides the (Debian) values in Site.pm.
#
# If you use a flavor of SuSE Linux, the ivata op install script should link
# this file as local.pl. If you wish to make changes, please remove the link and
# then COPY the file to local.pl. Doing this will ensure your changes are not
# ovewritten by the ivata op install script in later editions.
#
################################################################################
# Copyright (c) 2001 - 2005 ivata limited.
# All rights reserved.
# ---------------------------------------------------------
# ivata groupware may be redistributed under the GNU General Public
# License as published by the Free Software Foundation;
# version 2 of the License.
#
# These programs are free software; you can redistribute them and/or
# modify them under the terms of the GNU General Public License
# as published by the Free Software Foundation; version 2 of the License.
#
# These programs are distributed in the hope that they will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
#
# See the GNU General Public License in the file LICENSE.txt for more
# details.
#
# If you would like a copy of the GNU General Public License write to
#
# Free Software Foundation, Inc.
# 59 Temple Place - Suite 330
# Boston, MA 02111-1307, USA.
#
#
# To arrange commercial support and licensing, contact ivata at
#                  http://www.ivata.com/contact.jsp
################################################################################
#
# $Log: os_suse.pl,v $
# Revision 1.2  2005/04/09 17:19:52  colinmacleod
# Changed copyright text to GPL v2 explicitly.
#
# Revision 1.1.1.1  2005/03/10 17:49:14  colinmacleod
# Restructured ivata op around Hibernate/PicoContainer.
# Renamed ivata groupware.
#
# Revision 1.1  2004/11/03 18:23:25  colinmacleod
# Restructured Site.pm files.
#
################################################################################

# this should match the output from the passwd command
$PASSWD_EXPECT = "New password: ";
# type a short password to check this matches
$PASSWD_EXPECT_BAD = "Bad password: [^\n]+\n";
$PASSWD_EXPECT_CONFIRM = "Re-enter new password";
$PASSWD_EXPECT_SUCCESS = "Password changed";

# touch does not live at the same place as in debian
$TOUCH = "/bin/touch";
# user ids start at 1000 in SuSE
$UID_FIRST = 1000;

